package org.sanskar;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import com.fasterxml.jackson.databind.JsonNode;
import org.sanskar.coin.Coin;
import org.sanskar.trader.Trader;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

/**
 * The executor service internally calls the run() method when executed with the runnable interface
 */
public class ExecuteTransaction implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(ExecuteTransaction.class.getName());

    private JsonNode transaction;
    private CountDownLatch latch;
    private List<Coin> coins;
    private List<Trader> traders;

    public ExecuteTransaction(JsonNode transaction, CountDownLatch latch, List<Coin> coins, List<Trader> traders) {
        this.transaction = transaction;
        this.latch = latch;
        this.coins = coins;
        this.traders = traders;
    }


    @Override
    public void run() {
        try {
            String transactionType = transaction.get("type").asText();
            JsonNode jsondata = transaction.get("data");

            switch (transactionType) {
                case "BUY":
                    executeBuyTransactions(jsondata);
                    break;
                case "SELL":
                    executeSellTransactions(jsondata);
                    break;
                case "UPDATE_PRICE":
                    executeUpdate_PriceTransactions(jsondata);
                    break;
                case "ADD_VOLUME":
                    executeAdd_VolumeTransactions(jsondata);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // synchronisation utility allows for one thread to finish before others interrupt
            latch.countDown();
        }
    }

    public void executeBuyTransactions(JsonNode jsondata) {

        // Retrieving data for a particular coin
        String coindata = jsondata.get("coin").asText();
        double reqQuantity = jsondata.get("quantity").asDouble();  // Use double for decimal values
        String walletdata = jsondata.get("wallet_address").asText();

        // Finding corresponding coin in the coin list
        Coin targetCoin = coins.stream()
                .filter(coin -> coin.getSymbol().equals(coindata))
                .findFirst()
                .orElse(null);

        if (targetCoin != null) {

            Lock lock = new ReentrantLock();
            Condition pendingCondition = lock.newCondition();

            // Thread safety using synchronized
            synchronized (targetCoin) {

                while (Double.parseDouble(targetCoin.getCirculatingSupply()) < reqQuantity) {
                    try {
                        LOGGER.info("Not enough volume for buy transactions. Waiting for volume to increase.");
                        targetCoin.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                targetCoin.decreaseVolume((long) reqQuantity);
                LOGGER.info("Transactions processed successfully for coin " + coindata);

                // Updating trader's portfolio
                Trader trader = traders.stream()
                        .filter(trader1 -> trader1.getWalletAddress().equals(walletdata))
                        .findFirst()
                        .orElse(null);

                if (trader != null) {
                    trader.addToPortfolio(targetCoin, (long) reqQuantity);
                } else {
                    LOGGER.info("Trader not found with specified wallet address " + walletdata);
                }

                targetCoin.notifyAll();
            }
        }
    }

    public void executeSellTransactions(JsonNode jsondata) {
        String coindata = jsondata.get("coin").asText();
        long sellQuantity = jsondata.get("quantity").asLong();
        String walletdata = jsondata.get("wallet_address").asText();

        Coin targetCoin = coins.stream()
                .filter(coin -> coin.getSymbol().equals(coindata))
                .findFirst()
                .orElse(null);

        if (targetCoin != null) {
            synchronized (targetCoin) {
                long currentVolume = Long.parseLong(targetCoin.getCirculatingSupply());
                targetCoin.increaseVolume(sellQuantity);

                LOGGER.info("Sell transaction processed successfully for coin " + coindata);

                Trader trader = traders.stream()
                        .filter(trader1 -> trader1.getWalletAddress().equals(walletdata))
                        .findFirst()
                        .orElse(null);

                if (trader != null) {
                    trader.removeFromPortfolio(targetCoin, sellQuantity);
                } else {
                    LOGGER.info("Trader not found with specified wallet address " + walletdata);
                }

                targetCoin.notifyAll();
            }
        }
    }

    public void executeUpdate_PriceTransactions(JsonNode jsondata) {
        String coindata = jsondata.get("coin").asText();
        String newPrice = jsondata.get("price").asText();

        Coin targetCoin = coins.stream()
                .filter(coin -> coin.getSymbol().equals(coindata))
                .findFirst()
                .orElse(null);

        if (targetCoin != null) {
            synchronized (targetCoin) {
                targetCoin.setPrice(newPrice);
                LOGGER.info("Update Price transaction processed successfully for coin " + coindata);
                targetCoin.notifyAll();
            }
        }
    }

    public void executeAdd_VolumeTransactions(JsonNode jsondata) {
        String coindata = jsondata.get("coin").asText();
        // Change the type to double for decimal values
        double additionalVolume = jsondata.get("volume").asDouble();

        Coin targetCoin = coins.stream()
                .filter(coin -> coin.getSymbol().equals(coindata))
                .findFirst()
                .orElse(null);

        if (targetCoin != null) {
            synchronized (targetCoin) {
                // Update to use double instead of long
                double currentVolume = Double.parseDouble(targetCoin.getCirculatingSupply());
                targetCoin.increaseVolume((long) additionalVolume);
                LOGGER.info("Add Volume transaction processed successfully for coin " + coindata);
                targetCoin.notifyAll();
            }
        }
    }

}

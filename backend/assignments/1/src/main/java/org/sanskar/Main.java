package org.sanskar;
import org.sanskar.coin.Coin;
import org.sanskar.json.JsonReader;
import org.sanskar.trader.Trader;
import org.sanskar.coin.coinHelper;
import org.sanskar.trader.tradingHelper;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.sanskar.csvReader.*;
import java.util.logging.Logger;


public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    private static ExecutorService executorService;
    private static List<Coin> coins;
    private static List<Trader> traders;

    public static void main(String[] args) throws IOException, InterruptedException {

        String coinPath = "src/main/resources/coins.csv";
        String traderPath = "src/main/resources/traders.csv";
        String jsonPath = "src/main/resources/large_transaction.json";

        // Loading csv files
        coins = readCoins(coinPath);
        traders = readTraders(traderPath);

//-------------------------------------------------------
        int topN = 5;  // Adjust as needed

        LOGGER.info("-------------------------------------------------");
        // Get top N coins
        List<Coin> topCoins = coinHelper.getTopCoins(coins, topN);

        // Show portfolio for a trader
        Trader trader = traders.get(0);
        tradingHelper.showPortfolio(trader);

        // Get top N traders
        List<Trader> topTraders = LeaderboardService.getTopTraders(traders, topN);

        // Get bottom N traders
        List<Trader> bottomTraders = LeaderboardService.getBottomTraders(traders, topN);
        LOGGER.info("Top N Coins:");
        for (Coin coin : topCoins) {
            LOGGER.info(coin.getName() + " - " + coin.getPrice());
        }
        LOGGER.info("-------------------------------------------------");
        LOGGER.info("\nTrader Portfolio:");
        tradingHelper.showPortfolio(trader);
        LOGGER.info("-------------------------------------------------");
        LOGGER.info("\nTop N Traders:");
        for (Trader topTrader : topTraders) {
            LOGGER.info(topTrader.getFirstName() + " " + topTrader.getLastName());
        }
        LOGGER.info("-------------------------------------------------");
        LOGGER.info("\nBottom N Traders:");
        for (Trader bottomTrader : bottomTraders) {
           LOGGER.info(bottomTrader.getFirstName() + " " + bottomTrader.getLastName());
        }
        LOGGER.info("-------------------------------------------------");
//--------------------------------------------------

        // Loading Json files
        JsonNode jsonTransactions = JsonReader.readJsonFile(jsonPath);
        if (jsonTransactions == null) {
           LOGGER.info("debug: null");
            return;
        }

        // Countdown latch to synchronize execution tandem with threads
        CountDownLatch countDownLatch = new CountDownLatch(jsonTransactions.size());

        // Thread Pool
        int availableThreads = Runtime.getRuntime().availableProcessors();
        executorService = Executors.newFixedThreadPool(availableThreads);

        // handling transactions
        executeTransactions(jsonTransactions, countDownLatch);

        // waiting for all threads to finish
        countDownLatch.await();

        // shutdown threadPool usage
        executorService.shutdown();
    }

    private static String getBlockHash() {
        String saltChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder transactionHash = new StringBuilder();
        Random rnd = new Random();

        for (double i = 0; i < 199999999; i++) {}

        while (transactionHash.length() < 128) {
            int index = rnd.nextInt(saltChars.length());
            transactionHash.append(saltChars.charAt(index));
        }

        String hashCode = transactionHash.toString();
        return "0x" + hashCode.toLowerCase();
    }

    private static void storeBlockHash(String blockHash) throws IOException {
        FileIO fileIO = new FileIO();
        fileIO.appendToFile("block_hashes.txt", blockHash);
    }


    public static void executeTransactions(JsonNode jsonTransactions, CountDownLatch latch) throws IOException {

        for(JsonNode transactions : jsonTransactions){
            ExecuteTransaction executeTransaction = new ExecuteTransaction(transactions, latch, coins, traders);
            executorService.submit(executeTransaction);

            String blockHash = getBlockHash();

            storeBlockHash(blockHash);
        }

    }
}
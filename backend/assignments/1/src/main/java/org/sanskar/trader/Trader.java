package org.sanskar.trader;

import org.sanskar.coin.Coin;

import java.util.*;

public class Trader {

    private String firstName;
    private String lastName;
    private String phone;
    private String walletAddress;
    private List<Coin> portfolio;

    public Trader(String firstName, String lastName, String phone, String walletAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.walletAddress = walletAddress;
        this.portfolio = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void addToPortfolio(Coin coin, long quantity) {
        for (Coin existingCoin : portfolio) {
            if (existingCoin.getSymbol().equals(coin.getSymbol())) {
                // Coin is already in the portfolio, update the quantity
                existingCoin.increaseVolume(quantity);
                return;
            }
        }

        Coin newCoin = new Coin(coin.getRank(), coin.getName(), coin.getSymbol(), coin.getPrice(), "0");
        newCoin.increaseVolume(quantity);
        portfolio.add(newCoin);
    }

    public void removeFromPortfolio(Coin coin, long quantity) {
        for (Coin existingCoin : portfolio) {
            if (existingCoin.getSymbol().equals(coin.getSymbol())) {
                // Coin is in the portfolio, update the quantity or remove if necessary
                if (existingCoin.getVolume() > quantity) {
                    existingCoin.decreaseVolume(quantity);
                } else {
                    portfolio.remove(existingCoin);
                }
                return;
            }
        }
    }

    public List<Coin> getPortfolio() {
        // Return a copy of the portfolio to ensure encapsulation
        return new ArrayList<>(portfolio);
    }

    public double calculateProfitOrLoss() {
        double totalInvestment = 0.0;
        double currentValue = 0.0;

        for (Coin coin : portfolio) {
            totalInvestment += coin.getVolume() * Double.parseDouble(coin.getPrice());
            currentValue += coin.getVolume() * Double.parseDouble(getCurrentPrice(coin));
        }

        return currentValue - totalInvestment;
    }

    private String getCurrentPrice(Coin coin) {
        return coin.getCurrentPrice();
    }


    @Override
    public String toString() {
        return "Trader{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", walletAddress='" + walletAddress + '\'' +
                '}';
    }


}

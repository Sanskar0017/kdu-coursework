package org.sanskar;

import org.apache.commons.csv.*;
import org.sanskar.coin.Coin;
import org.sanskar.trader.Trader;

import java.io.*;
import java.util.*;

public class csvReader {

    public static List<Coin> readCoins(String filePath) throws IOException{
        List<Coin> coins = new ArrayList<>();

        try (Reader reader = new FileReader(filePath);
             CSVParser csvParser = CSVFormat.DEFAULT.parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
                String rank = csvRecord.get(0);
                String name = csvRecord.get(1);
                String symbol = csvRecord.get(2);
                String price = csvRecord.get(3);
//                double price = Double.parseDouble(csvRecord.get(3));
                String circulatingSupply = csvRecord.get(4);

                Coin coin = new Coin(rank, name, symbol, price, circulatingSupply);
                coins.add(coin);
            }
        }

        return coins;
    }

    public static List<Trader> readTraders(String filePath) throws IOException {
        List<Trader> traders = new ArrayList<>();

        try (FileReader reader = new FileReader(filePath);
             CSVParser csvParser = CSVFormat.DEFAULT.withHeader().parse(reader)) {

            for (CSVRecord record : csvParser) {
                String firstName = record.get("first_name");
                String lastName = record.get("last_name");
                String phone = record.get("phone");
                String walletAddress = record.get("Wallet Address");

                Trader trader = new Trader(firstName, lastName, phone, walletAddress);
                traders.add(trader);
            }
        }

        return traders;
    }





}

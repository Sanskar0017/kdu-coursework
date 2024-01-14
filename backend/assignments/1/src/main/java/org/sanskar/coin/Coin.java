package org.sanskar.coin;
import org.sanskar.json.JsonReader;

import java.util.logging.Logger;
public class Coin {
    private static Logger LOGGER = Logger.getLogger(Coin.class.getName());

    private String rank;
    private String name;
    private String symbol;
    private String price;
    private String circulatingSupply;
    private long volume;

    public Coin(String rank, String name, String symbol, String price, String circulatingSupply) {
        this.rank = rank;
        this.name = name;
        this.symbol = symbol;
        this.price = price;
        this.circulatingSupply = circulatingSupply;
        this.volume = 0;
    }

    public String getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getPrice() {
        return price;
    }

    public long getVolume() {
        return volume;
    }

    public String getCirculatingSupply() {
        return circulatingSupply;
    }



    public synchronized void increaseVolume(long quantity) {
        double currentVolume = Double.parseDouble(circulatingSupply);
        circulatingSupply = String.valueOf((long) (currentVolume + quantity));
    }


    public synchronized void decreaseVolume(long quantity) {
        long currentVolume = Long.parseLong(circulatingSupply);
        if (currentVolume >= quantity) {
            circulatingSupply = String.valueOf(currentVolume - quantity);
        } else {
            LOGGER.info("Error: Insufficient volume for decreaseVolume.");
        }
    }

    public void setPrice(String price) {
        this.price = price;
    }



    @Override
    public String toString() {
        return "Coin{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", price=" + price +
                ", circulatingSupply=" + circulatingSupply +
                '}';
    }


    public String getCurrentPrice() {
        return price;
    }
}

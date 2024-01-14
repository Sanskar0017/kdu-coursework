package org.sanskar.coin;
import java.util.*;
import java.util.stream.Collectors;

/**
 * retreiving coins details
 */
public class coinHelper {

    private List<Coin> coins;

    public coinHelper(List<Coin> coins){
        this.coins = coins;
    }

    public Optional<Coin> getCoinDetails(String code){
        return Optional.ofNullable(coins.stream()
                .filter(coin -> coin.getSymbol().equals(code))
                .findFirst()
                .orElse(null));
    }

    public static List<Coin> getTopCoins(List<Coin> coins, int n) {
        return coins.stream()
                .sorted(Comparator.comparing(Coin::getPrice).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }

}

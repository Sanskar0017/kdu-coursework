package org.sanskar.trader;
import java.util.*;
import org.sanskar.coin.Coin;
import java.util.logging.Logger;
/**
 * calculating profit / loss
 */
public class tradingHelper {

    private List<Coin> coins;
    private List<Coin> portfolio;
    private static final Logger LOGGER = Logger.getLogger(tradingHelper.class.getName());

    public tradingHelper(List<Coin> coins){
        this.coins = coins;
    }

    public static void showPortfolio(Trader trader) {
        trader.getPortfolio().forEach(coin -> LOGGER.info(coin.getName() + " " + coin.getVolume()));
    }





}

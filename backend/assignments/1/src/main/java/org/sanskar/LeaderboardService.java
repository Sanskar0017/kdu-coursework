package org.sanskar;

import org.sanskar.trader.Trader;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LeaderboardService {

    private List<Trader> traders;

    public LeaderboardService(List<Trader> traders) {
        this.traders = traders;
    }

    public static List<Trader> getTopTraders(List<Trader> traders, int n) {
        return traders.stream()
                .sorted(Comparator.comparing(Trader::calculateProfitOrLoss).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }

    public static List<Trader> getBottomTraders(List<Trader> traders, int n) {
        return traders.stream()
                .sorted(Comparator.comparing(Trader::calculateProfitOrLoss))
                .limit(n)
                .collect(Collectors.toList());
    }
}

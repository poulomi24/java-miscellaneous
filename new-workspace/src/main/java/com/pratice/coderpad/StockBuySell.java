package com.pratice.coderpad;

public class StockBuySell {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0; // Not enough prices to make a profit
        }

        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                maxProfit = maxProfit + prices[i] - prices[i-1];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {100, 180, 260, 310, 40, 535, 695};
        int maxProfit = maxProfit(prices);
        System.out.println("Maximum profit: " + maxProfit);
    }
}


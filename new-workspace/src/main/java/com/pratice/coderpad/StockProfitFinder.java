package com.pratice.coderpad;

public class StockProfitFinder {
    public static void main(String[] args) {
        int[] stockPrices = {67, 56, 34, 90, 29, 45, 78, 100, 12, 25}; // Example stock prices

        StockProfit result = findMaxProfit(stockPrices);
        System.out.println("Max Profit: $" + result.profit);
        System.out.println("Buy on day: " + result.buyDay);
        System.out.println("Sell on day: " + result.sellDay);
    }

    static class StockProfit {
        int profit;
        int buyDay;
        int sellDay;
    }

    public static StockProfit findMaxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            throw new IllegalArgumentException("At least two stock prices are required.");
        }

        int buyDay = 0;
        int sellDay = 0;
        int maxProfit = 0;
        int minPrice = prices[0];

        for (int i = 1; i < n; i++) {
            if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
                sellDay = i;
            }
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                buyDay = i;
            }
        }

        StockProfit result = new StockProfit();
        result.profit = maxProfit;
        result.buyDay = buyDay;
        result.sellDay = sellDay;
        return result;
    }
}




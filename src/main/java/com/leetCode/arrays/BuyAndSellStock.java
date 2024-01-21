package com.leetCode.arrays;

public class BuyAndSellStock {


    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice)
                minPrice = price;
            else if (price - minPrice > maxProfit)
                maxProfit = price - minPrice;
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        int maxProfit = 0; // Initialize the maximum profit
        int minPrice = Integer.MAX_VALUE; // Initialize the minimum price

        for (int price : prices) {
            // Calculate and update the maximum profit
            maxProfit = Math.max(maxProfit, price - minPrice);
            // Update the minimum price
            minPrice = Math.min(minPrice, price);
        }

        return maxProfit;
    }


    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        BuyAndSellStock buyAndSellStock = new BuyAndSellStock();
        System.out.println(buyAndSellStock.maxProfit(prices));
        System.out.println(buyAndSellStock.maxProfit2(prices));
    }
}

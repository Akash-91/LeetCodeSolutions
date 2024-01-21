package com.top150.arrays;

public class BuyAndSellStock {

    public static void main(String[] args) {
        int prices[] = {7, 1, 5, 3, 6, 4};


        System.out.println(maxProfit(prices));
    }


    public static int maxProfit(int[] prices) {

        int minValue = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minValue)
                minValue = price;
            else if (price - minValue > maxProfit)
                maxProfit = price - minValue;
        }
        return maxProfit;
    }
}

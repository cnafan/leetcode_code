package com.leetcode.array.console1475;

public class FinalPrices {
    public static void main(String[] args) {
        int[]res=new FinalPrices().finalPrices(new int[]{8,4,6,2,3});
        for (int re : res) {
            System.out.println(re);
        }
    }

    public int[] finalPrices(int[] prices) {
        int[] res=new int[prices.length];
        for (int i = 0; i < res.length; i++) {
            res[i]= prices[i]-finddiff(prices,i);
        }
        return res;
    }

    public int finddiff(int[] prices, int i) {
        if (i == prices.length - 1) {
            return 0;
        }
        if (prices[i + 1] < prices[i]) {
            return prices[i];
        }
        return finddiff(prices, i + 1);
    }
}

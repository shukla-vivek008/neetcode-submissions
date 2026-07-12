class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        int totalProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = price - minPrice;
                totalProfit += maxProfit;
                maxProfit = 0;
                minPrice = price;
            }
        }

        return totalProfit;
    }
}
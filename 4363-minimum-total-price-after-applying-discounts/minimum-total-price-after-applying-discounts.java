class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int i = prices.length - 1;
        int j = discounts.length - 1;
        double ans = 0.0;
        while (i >= 0 && j >= 0) {
            int v = prices[i];
            int d = discounts[j];
            ans += (double) v * (100 - d) / 100;
            i--;
            j--;
        }
        while (i >= 0) {
            ans += prices[i];
            i--;
        }
        return ans;
    }
}
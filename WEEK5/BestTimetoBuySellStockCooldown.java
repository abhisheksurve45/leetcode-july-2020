public class BestTimetoBuySellStockCooldown {

    /**
     * Reference : 1. https://www.youtube.com/watch?v=2YZMI6-D7Jo
     *              2. https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/548/week-5-july-29th-july-31st/3405/discuss/761742/JAVA-or-DP-or-Explained-in-detail-or-1-ms
     */
    class Solution {

        // dp[i][0] = max profit on day i with 0 stocks in hand

        // dp[i][1] = max profit on day i with 1 stocks in hand

        public int maxProfit(int[] prices) {

            int n = prices.length;

            if (n <= 1) return 0;

            int[][] dp = new int[n][2];

            // day1
            dp[0][0] = 0;
            dp[0][1] = -prices[0];

            // day2
            dp[1][0] = Math.max(0, dp[0][1] + prices[1]);
            dp[1][1] = Math.max(dp[0][1], -prices[1]);

            for (int i = 2; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            }

            return dp[n - 1][0];
        }
    }

    /**
     * Reference : https://www.youtube.com/watch?v=UlWFaWv8wWU
     */
    class Solution {

        public int maxProfit(int[] prices) {

            int sold = Integer.MIN_VALUE, held = Integer.MIN_VALUE, reset = 0;

            for (int price : prices) {
                int presold = sold;
                sold = held + price;
                held = Math.max(held, reset - price);
                reset = Math.max(reset, presold);
            }

            return Math.max(reset, sold);
        }
    }

}

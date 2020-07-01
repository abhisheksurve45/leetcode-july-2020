public class ArrangingCoins {

    /**
     * Simple O(n) solution
     */
    class Solution {
        public int arrangeCoins(int n) {
            if (n == 0) return 0;
            if (n == 1 || n == 2) return 1;
            int stairs = 0;
            for (int i = 1; i <= n; i++) {
                stairs++;
                n -= i;
            }
            return stairs;
        }
    }

    /**
     * Math solution
     * Reference : @see <a href="https://leetcode.com/problems/arranging-coins/discuss/92298/Java-O(1)-Solution-Math-Problem">LEETCODE DISCUSS</a>
     */
    class Solution {
        public int arrangeCoins(int n) {
            return (int) ((-1 + Math.sqrt(1 + 8 * (long) n)) / 2);
        }
    }
}

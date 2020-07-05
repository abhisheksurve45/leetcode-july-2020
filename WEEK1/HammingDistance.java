public class HammingDistance {
    /**
     * Reference : https://www.youtube.com/watch?v=oGU1At1GFvc
     */
    class Solution {
        public int hammingDistance(int x, int y) {
            int dist = 0;

            while (x > 0 || y > 0) {
                dist += x % 2 ^ y % 2;
                x >>= 1;
                y >>= 1;
            }

            return dist;
        }
    }
}

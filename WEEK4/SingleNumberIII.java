public class SingleNumberIII {

    /**
     * Reference : https://leetcode.com/problems/single-number-iii/discuss/68901/Sharing-explanation-of-the-solution
     */

    class Solution {
        public int[] singleNumber(int[] nums) {
            int diff = 0;

            for (int num : nums) {
                diff ^= num;
            }

            diff &= -diff;

            int[] result = {0, 0};

            for (int num : nums) {
                if ((num & diff) == 0) {
                    result[0] ^= num;
                } else {
                    result[1] ^= num;
                }
            }

            return result;
        }
    }
}

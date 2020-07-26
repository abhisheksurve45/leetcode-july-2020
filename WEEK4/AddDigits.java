public class AddDigits {

    /**
     * Intuitive solution
     */
    class Solution {
        public int addDigits(int num) {
            while (num >= 10) {
                int temp = 0;
                while (num != 0) {
                    temp += num % 10;
                    num = num / 10;
                }
                num = temp;
            }
            return num;
        }
    }

    class Solution {
        public int addDigits(int num) {

            if (num == 0) return 0;

            if (num % 9 == 0) return 9;

            return num % 9;
        }
    }
}

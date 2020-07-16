public class Pow {

    class Solution {
        public double myPow(double x, int n) {
            return myPow(x, 1L * n);
        }

        private double myPow(double x, long n) {
            if (n == 0)
                return 1;
            if (n < 0)
                return myPow(1 / x, -n);
            return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
        }
    }

}

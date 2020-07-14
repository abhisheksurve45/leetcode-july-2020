public class AngleBetweenHandsofClock {
    class Solution {
        public double angleClock(int hour, int minutes) {
            double angle = Math.abs(30.0 * hour + 0.5 * minutes - 6 * minutes);
            return angle <= 180.0 ? angle : 360 - angle;
        }
    }
}

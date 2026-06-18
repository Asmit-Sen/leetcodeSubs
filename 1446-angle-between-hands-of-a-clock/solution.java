class Solution {
    public double angleClock(int hour, int minutes) {
        double ans = Math.abs((30.0 * hour) - (5.5 * minutes));
        return (double)Math.min(ans, 360.0- ans);
    }
}

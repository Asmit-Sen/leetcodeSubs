class Solution {
    public int minSensors(int n, int m, int k) {
        return (int)Math.ceil(n/(float)(2*k+1))*(int)Math.ceil(m/(float)(2*k+1));
    }
}

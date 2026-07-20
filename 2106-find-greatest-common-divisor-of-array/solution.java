class Solution {
    int gcd (int x, int y){
        
        if (y==0) return x;
        return gcd(y, x%y);
    }
    public int findGCD(int[] nums) {
        int maxi = (int)-1e9;
        int mini = (int)1e9;

        for(int x:nums){
            maxi = (int)Math.max(maxi, x);
            mini = (int)Math.min(mini, x);
        }

        return gcd(maxi, mini);
    }
}

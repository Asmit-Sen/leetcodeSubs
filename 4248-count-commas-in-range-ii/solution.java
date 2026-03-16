class Solution {
    public long countCommas(long n) {
        long ans = 0;
        long multiplier = 1000;
        
        while (n >= multiplier) {
            ans += (n - multiplier + 1);
            
            if (multiplier > Long.MAX_VALUE / 1000) break;
            multiplier *= 1000;
        }
        
        return ans;
    }
}


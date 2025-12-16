class Solution {
    public long getDescentPeriods(int[] prices) {
        
        long ans=0;
        int prev=prices[0], n=prices.length;
        
        int cnt=1;
        for(int i=1;i<n;i++){
            if (prices[i]==prices[i-1]-1){
                cnt++;
            }
            else{
                ans += (long) cnt*(cnt+1)/2;
                cnt = 1;
            }
        }
        return (long) ans + (long) cnt*(cnt+1)/2;   
    }
}

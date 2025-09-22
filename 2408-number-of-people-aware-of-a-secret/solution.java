class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long dp[]=new long[n+1];
        long mod=(int)1e9+7;

        dp[1]=1;
        long know=0;
        for(int i=2;i<=n;i++){
         
            if(i-delay>0) know+=dp[i-delay]%mod;
            if(i-forget>0) know-=dp[i-forget]%mod;

            dp[i]=know;
        }
        long ans=0;
        for(int i=n-forget+1;i<=n;i++) ans+=dp[i]%mod;

        return (int)(ans%mod);
    }   
}

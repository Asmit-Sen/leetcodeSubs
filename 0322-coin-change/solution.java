class Solution {
    int f(int i, int arr[], int amt, int dp[][])
    {
        if(amt==0) return 0;
        if(i==0) return (amt%arr[0]==0)?amt/arr[0]:(int)1e9;
        if(dp[i][amt]!=-1) return dp[i][amt];

        int l=(int)1e9,r=(int)1e9;
        l=f(i-1,arr,amt,dp);
        if(amt>=arr[i]) r=1+f(i,arr,amt-arr[i],dp);

        return dp[i][amt]=(int)Math.min(l,r);
    }
    public int coinChange(int[] coins, int amount) {
        int dp[][]=new int[coins.length][amount+1];
        for(int row[]:dp)
        Arrays.fill(row,(int)1e9);
        
        for(int i=0;i<coins.length;i++) 
        dp[i][0]=0;
        
        for(int j=0;j<=amount;j++)
        dp[0][j]=(j%coins[0]==0)?j/coins[0]:(int)1e9;

        int l=(int)1e9,r=(int)1e9;

        for(int i=1;i<coins.length;i++)
        {
            for(int amt=1;amt<=amount;amt++)
            {
                l=dp[i-1][amt];
                if(amt>=coins[i]) r=1+dp[i][amt-coins[i]];
                dp[i][amt]=(int)Math.min(l,r);
            }
        }
        int ans=dp[coins.length-1][amount];
        return (ans==(int)1e9)?-1:ans;
    }
}

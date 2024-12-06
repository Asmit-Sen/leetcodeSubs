class Solution {
    int f(int coins[],int i, int amount, int dp[][])
    {

        if(amount==0) return 0;// no more coins needed 
        if(i<0) return (int)1e9; 

        if(dp[i][amount]!=-1)
        return dp[i][amount];

        int take=(int)1e9;// INT_MAX can overflow
        if(coins[i]<=amount) take= 1 + f(coins,i,amount-coins[i],dp);
        int not_take=f(coins,i-1,amount,dp);

        return dp[i][amount]=(int)Math.min(take,not_take);
    }
    public int coinChange(int[] coins, int amount) {
        int dp[][]=new int[coins.length][amount+1];
        for(int row[]:dp)
        Arrays.fill(row,-1);
        
        for(int j=0;j<=amount;j++)
        dp[0][j]=(j%coins[0]==0)?j/coins[0]:(int)1e9; //if only a single coin available, check if divisible

        for(int i=0;i<coins.length;i++)
        dp[i][0]=0;//base case

        
        for(int i=1;i<coins.length;i++)
        {
            for(int amt=1;amt<=amount;amt++)
            {
                int take=(int)1e9;// INT_MAX can overflow
                if(coins[i]<=amt) take= 1 + dp[i][amt-coins[i]];
                int not_take=dp[i-1][amt];

                dp[i][amt]=(int)Math.min(take,not_take);
            }
        }

        int ans= dp[coins.length-1][amount];
        return ans==(int)1e9?-1:ans;
    }
}

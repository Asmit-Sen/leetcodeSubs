class Solution {
    int f(int digit, int n, int k, int dp[][]){

        if(n==0) return 1;
        if(n<0 || digit==0) return 0;

        if(dp[n][digit]!=-1) return dp[n][digit];
        //take this digit^k or not
        return dp[n][digit] = ( f(digit-1,n-(int)Math.pow(digit,k),k,dp) + f(digit-1,n,k,dp) ) %((int)1e9+7);
    }
    public int numberOfWays(int n, int x) {
        int dp[][]=new int[n+1][n+1];
        for(int row[]:dp) Arrays.fill(row,-1);

        return f(n,n,x,dp)%((int)1e9+7);
    }
    
}


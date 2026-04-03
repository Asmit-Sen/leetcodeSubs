class Solution {
    int f(int i, int j, int n, int m, int k, int coins[][], Integer dp[][][]){
        if (i>=n || j>=m) return (int)-1e9;

        if (i==n-1 && j==m-1){
            if (coins[i][j]>=0) return coins[i][j];
            return k>0 ? 0 : coins[i][j]; 
        }

        if (dp[i][j][k]!=null) return dp[i][j][k];

        int shielded = (int)-1e9, not_shielded = (int)-1e9;

        // if positive, always take. If negative, but no shield take anyway 
        not_shielded = coins[i][j] + (int)Math.max(
            f(i+1, j, n, m, k, coins, dp), 
            f(i, j+1, n, m, k, coins, dp)
        );
        
        // choose to shield here or not
        if (coins[i][j]<0 && k>0) shielded = (int)Math.max(
            f(i+1, j, n, m, k-1, coins, dp),
            f(i, j+1, n, m, k-1, coins, dp)
            );
        
        return dp[i][j][k] = (int)Math.max(shielded, not_shielded);  
    }
    public int maximumAmount(int[][] coins) {
        int n = coins.length, m = coins[0].length;
        Integer dp[][][] = new Integer[n][m][3];
        return f(0,0,n,m,2, coins, dp);
    }
}

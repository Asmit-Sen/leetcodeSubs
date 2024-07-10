class Solution {
    int path (int m, int n,int dp[][])
    {
        if(m==0 && n==0) return 1;
        if(m<0 || n<0) return 0;

        if(dp[m][n]!=-1) return dp[m][n]; //memo
        
        int l=path(m-1,n,dp); //up
        int r=path(m,n-1,dp); //left

        return dp[m][n]=l+r;//memo
    }
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];// memo
        for(int[] row:dp)
        Arrays.fill(row,-1);

        for(int i=0;i<m;i++)// tabulation
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0) dp[i][j]=1;
                else 
                {
                    int l=0,r=0;
                    if(i>0) l=dp[i-1][j];
                    if(j>0) r=dp[i][j-1];
                    dp[i][j]=l + r;
                }
            }
        }
        return dp[m-1][n-1];
    }
}

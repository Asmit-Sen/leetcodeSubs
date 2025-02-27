class Solution {
    int f(int m, int n)
    {
        if(m<0 || n<0) return 0;
        if(m==0 && n==0) return 1;

        return f(m-1,n)+f(m,n-1);
    }
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        for(int row[]:dp)
        Arrays.fill(row,0);

        int l=0,r=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0) dp[i][j]=1;
                else
                {
                    l=0;r=0;
                    if(i>0) l=dp[i-1][j];
                    if(j>0) r=dp[i][j-1];
                    dp[i][j]=l+r;
                }
            }
        }
        return dp[m-1][n-1];

        // return f(m-1,n-1);
    }
}

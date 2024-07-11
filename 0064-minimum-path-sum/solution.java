class Solution {
    int path(int m, int n, int grid[][], int dp[][])
    {
        if(m==0 && n==0) return grid[0][0];
        if(m<0 || n<0) return (int)Math.pow(10,9);
        if(dp[m][n]!=-1) return dp[m][n];//memo

        int up= grid[m][n]+ path(m-1,n,grid,dp);
        int left=grid[m][n]+ path(m,n-1,grid,dp);
        return dp[m][n]=(int)Math.min(up,left);//memo

    }
    public int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        
        int dp[][]=new int[m][n];//memo
        for(int row[]:dp)
        Arrays.fill(row,-1);
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0) dp[i][j]=grid[0][0];
                else 
                {
                    int up=(int)Math.pow(10,9),left=(int)Math.pow(10,9);//we start with default large values so it doesnt overflow or disturb our min path sum
                    if(i>0)up=grid[i][j]+dp[i-1][j];
                    if(j>0)left=grid[i][j]+dp[i][j-1];
                    dp[i][j]=(int)Math.min(up,left);
                }
            }
        }
        return dp[m-1][n-1];
    }
}

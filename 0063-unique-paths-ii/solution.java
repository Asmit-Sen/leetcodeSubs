class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length,n=obstacleGrid[0].length;
        int dp[][]=new int[m][n];

        int prev[]=new int[n], curr[]=new int[n];

        // dp[0][0]=1;
        // dp[i][j]=0 if grid[i][j]=1
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(obstacleGrid[i][j]==1) curr[j]=0;
                else{
                    if(i==0 && j==0) curr[j]=1;
                    else
                    {
                        int left=0;
                        // if(i>0) up=prev[j];
                        if(j>0) left=curr[j-1];
                        curr[j]=prev[j]+left;
                    }
                    prev=curr;
                }
            }
        }
        return prev[n-1];
    }
}

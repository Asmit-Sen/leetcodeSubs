class Solution {
    int f(int i, int j, int n, int m, int[][] grid, int prev, int dp[][][]){
        if(i<0 || j<0 || i>=n ||j>=m) return 0;
        if(i==n-1 && j==m-1) {
            // return grid[i][j]==0?1:0;
            return 1;
        }

        if(dp[i][j][prev]!=-1) return dp[i][j][prev];

        int a=0,b=0;
        if(grid[i][j]==0){
            a=f(i,j+1,n,m,grid,1,dp)%(int)(1e9+7);
            b=f(i+1,j,n,m,grid,0,dp)%(int)(1e9+7);
            return dp[i][j][prev]=(a+b)%(int)(1e9+7);
        }
        else
        {
            //current cell is a mirror 
            //take into account the prevDirection and send it on its way

            if(prev==1)
                return dp[i][j][prev]=f(i+1,j,n,m,grid,0,dp)%(int)(1e9+7);
            else 
                return dp[i][j][prev]=f(i,j+1,n,m,grid,1,dp)%(int)(1e9+7);
        }
    }
    public int uniquePaths(int[][] grid) {
        // prev=1 for right, 0 for down
        int n=grid.length, m=grid[0].length;
        int dp[][][]=new int[n+1][m+1][2];
        for(int arr[][]:dp) 
            for(int row[]:arr)
                Arrays.fill(row,-1);
        
        return f(0,0,n,m,grid,0,dp);
    }
}

class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        // int dp[][]=new int[m][n];
        int prev[]=new int[n], cur[]=new int[n];

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0) cur[j]=grid[i][j];
                else
                {
                    int up=Integer.MAX_VALUE,left=Integer.MAX_VALUE;
                    if(i>0) up=prev[j];
                    if(j>0) left=cur[j-1];
                    cur[j]=(int)Math.min(up,left)+grid[i][j];
                }
                prev=cur;
            }
        }
        return prev[n-1];
    }
}

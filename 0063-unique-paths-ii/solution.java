class Solution {

    int path (int m, int n,int arr[][], int dp[][])
    {
        if(m<0 || n<0 || arr[m][n]==1) return 0;//-ve index or a block
        if(m==0 && n==0) return 1;

        if(dp[m][n]!=-1) return dp[m][n];//memo
    
        int l=path(m-1,n,arr,dp); //up
        int r=path(m,n-1,arr,dp); //left

        return dp[m][n]=l+r;//memo
    }
    
    public int uniquePathsWithObstacles(int[][] arr) {
        int m=arr.length,n=arr[0].length;
        int dp[][]=new int[m][n];//memo
        for(int row[]:dp)
        Arrays.fill( row,-1);

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(arr[i][j]==1) dp[i][j]=0;
                else if( i== 0 && j==0) dp[i][j]=1;
                else
                {
                    int up=0,left=0;
                    if(i>0) up=dp[i-1][j];
                    if(j>0) left=dp[i][j-1];
                    dp[i][j]=up+left;
                }
            }
        }
        return dp[m-1][n-1];
        
    }
}

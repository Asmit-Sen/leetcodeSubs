class Solution {
    int path(int i, int j, int arr[][], int dp[][])
    {
        if(j<0 || j>=arr.length) return (int)1e9;
        if(i==0) return arr[0][j];
        
        if(dp[i][j]!=-1) return dp[i][j];//memo

        int t=arr[i][j]+path(i-1,j,arr,dp);
        int tl=arr[i][j]+path(i-1,j-1,arr,dp);
        int tr=arr[i][j]+path(i-1,j+1,arr,dp);

        return dp[i][j]=(int)Math.min(t,(int)Math.min(tl,tr));
    }
    public int minFallingPathSum(int[][] arr) {
        int mini=(int)1e9;
        int n=arr.length;

        int dp[][]=new int[n][n];//memo
        for(int row[]:dp)
        Arrays.fill(row,0);

        for(int j=0;j<n;j++)
        dp[0][j]=arr[0][j];

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
               
                    int d=(int)1e9,dl=(int)1e9,dr=(int)1e9;
                    if(j>0) dl=arr[i][j]+dp[i-1][j-1];
                    if(j<n-1) dr=arr[i][j]+dp[i-1][j+1];
                    d=arr[i][j]+dp[i-1][j];

                    dp[i][j]=(int)Math.min(d,(int)Math.min(dl,dr));
            }
        }

        for(int j=0;j<n;j++)
        {
            mini=(int)Math.min(mini,dp[n-1][j]);
        }
        return mini;
    }
}

class Solution {
    int path( int i,int j, List<List<Integer>> list, int dp[][])
    {
        if(i==list.size()-1) return list.get(i).get(j);
        if(dp[i][j]!=-1) return dp[i][j];// memo
        
        int d=list.get(i).get(j)+ path(i+1,j,list,dp);
        int dr=list.get(i).get(j)+path(i+1,j+1,list,dp);
        return dp[i][j]=(int)Math.min(d,dr);//memo
    }
    public int minimumTotal(List<List<Integer>> list) {
        // int dp[][]=new int[list.size()-1][list.size()-1];
        // for(int row[]:dp)
        // Arrays.fill(row,-1);//memo
        
        // return path(0,0,list,dp);

        int n=list.size();
        int dp[][]=new int[n][n];

        if(n==1) return list.get(0).get(0);
        
        //base case is the last row
        for(int j=0;j<n;j++)
        {
            dp[n-1][j]=list.get(n-1).get(j);
        }
        for(int i=n-2;i>=0;i--) 
        {
            for(int j=i;j>=0;j--)
            {
                int d=list.get(i).get(j)+ dp[i+1][j];
                int dr=list.get(i).get(j)+dp[i+1][j+1];
                dp[i][j]=(int)Math.min(d,dr);
            }
        }
        return dp[0][0];
    }
}

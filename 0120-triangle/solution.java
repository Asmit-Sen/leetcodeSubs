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
        int dp[][]=new int[list.size()-1][list.size()-1];
        for(int row[]:dp)
        Arrays.fill(row,-1);//memo
        
        return path(0,0,list,dp);
    }
}

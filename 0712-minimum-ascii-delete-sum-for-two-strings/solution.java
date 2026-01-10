class Solution {
    int lcs(int i, int j, String s, String t, int dp[][]){
        if (i==0 || j==0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        
        if (s.charAt(i-1)==t.charAt(j-1))
            return dp[i][j] = s.charAt(i-1) + lcs(i-1,j-1,s,t,dp);
        return dp[i][j] = 
        (int)Math.max(lcs(i,j-1,s,t,dp), lcs(i-1,j,s,t,dp));
    }
    public int minimumDeleteSum(String s, String t) {
        int n=s.length(), m=t.length();
        int dp[][]=new int[n+1][m+1];
        for(int row[]:dp)
            Arrays.fill(row,-1);

        for(int i=0;i<=n;i++) dp[i][0]=0;
        for(int j=0;j<=m;j++) dp[0][j]=0;

        // int lcsValue = lcs(n,m,s,t,dp);    
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+s.charAt(i-1);
                }
                else 
                dp[i][j]=(int)Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }    
        int lcsValue = dp[n][m];

        int totalValues=0;
        for(char c:s.toCharArray())
            totalValues+=c;
        for(char c:t.toCharArray())
            totalValues+=c;

        return totalValues - 2 * lcsValue;
    }
}

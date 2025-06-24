class Solution {

    int lcs(int i, int j, char[] s1, char[] s2, int dp[][]){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1)return dp[i][j];

        if(s1[i]==s2[j]) return dp[i][j]=1+lcs(i-1,j-1,s1,s2,dp);
        else return dp[i][j]=(int)Math.max(lcs(i-1,j,s1,s2,dp), lcs(i,j-1,s1,s2,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();

        int dp[][]=new int[n+1][m+1];
        //0 maps to -1

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=(int)Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[n][m];
    }
}

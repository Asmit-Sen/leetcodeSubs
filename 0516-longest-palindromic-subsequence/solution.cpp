class Solution {
public:
    int longestPalindromeSubseq(string s) {
        int n=s.length();
        vector<vector<int>> dp(n+1,vector<int>(n+1,0));
        string t=string(s.rbegin(),s.rend());

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {                
                dp[i][j]=(s[i-1]==t[j-1])?(1+dp[i-1][j-1]):(max(dp[i][j-1],dp[i-1][j]));
            }
        }
        return dp[n][n];
    }
};

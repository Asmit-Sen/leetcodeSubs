class Solution {
public:
    string shortestCommonSupersequence(string text1, string text2) {
        int n=text1.length();
        int m=text2.length();
        string w="";
        vector<vector<int>> dp(n+1,vector<int>(m+1,0));
        // vector<int> prev(m+1,0);

        for(int i=1;i<=n;i++)
        {
            // vector<int>cur(m+1,0);
            for(int j=1;j<=m;j++)
            {
                dp[i][j]=(text1[i-1]==text2[j-1])?(1+dp[i-1][j-1]):(max(dp[i-1][j],dp[i][j-1]));
            }
            // prev=cur;
        }
        cout<<n+m-dp[n][m];
        
        int i=n,j=m;
        while(i>0 && j>0)
        {
            if(text1[i-1]==text2[j-1])
            {
                w+=text1[i-1];
                i--;
                j--;
            }
            else if (dp[i-1][j]>=dp[i][j-1])
            {
                w+=text1[i-1];
                i--;
            }
            else
            {
                w+=text2[j-1];
                j--;
            }
        }

        while(i>0) {w+=text1[i-1];i--;}
        while(j>0) {w+=text2[j-1];j--;}
        reverse(w.begin(),w.end());
        return w;
    }
};

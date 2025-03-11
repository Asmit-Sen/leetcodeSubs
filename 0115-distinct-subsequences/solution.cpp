class Solution {
public:
    int f(int i, int j, string &s, string &t, vector<vector<int>>& dp)
    {
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        // return dp[i][j]=(s[i]==t[j])?(f(i-1,j-1,s,t,dp)+f(i-1,j,s,t,dp)):f(i-1,j,s,t,dp);
        if(s[i]==t[j])
        return dp[i][j]=f(i-1,j-1,s,t,dp)+f(i-1,j,s,t,dp);
        else
        return dp[i][j]=f(i-1,j,s,t,dp);
    }
    int numDistinct(string s, string t) {
        int n=s.size();
        int m=t.size();
        vector<vector<double>> dp(n+1,vector<double>(m+1,0));

        vector<double> prev(m+1,0);
        prev[0]=1;
        // for(int i=0;i<=n;i++)
        // dp[i][0]=1;
        
        for(int i=1;i<=n;i++)
        {
            // vector<double> cur(m+1,0);
            // cur[0]=1;
            for(int j=m;j>=1;j--)
            {
                if(s[i-1]==t[j-1])
                prev[j]=prev[j-1]+prev[j];
                // else cur[j]=prev[j];
            }
            // prev=cur;
        }
        return (int)prev[m];

    }
};

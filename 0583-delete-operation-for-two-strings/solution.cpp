class Solution {
public:
    int minDistance(string text1, string text2) {
        int n=text1.length();
        int m=text2.length();

        // vector<vector<int>> dp(n+1,vector<int>(m+1,0));
        vector<int> prev(m+1,0);

        for(int i=1;i<=n;i++)
        {
            vector<int>cur(m+1,0);
            for(int j=1;j<=m;j++)
            {
                cur[j]=(text1[i-1]==text2[j-1])?(1+prev[j-1]):(max(prev[j],cur[j-1]));
            }
            prev=cur;
        }
        return n-prev[m]+m-prev[m];
    }
};

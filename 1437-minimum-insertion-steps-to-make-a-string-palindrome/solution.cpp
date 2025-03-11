class Solution {
public:
    int minInsertions(string text1) {
        int n=text1.length();
        string text2=string(text1.rbegin(), text1.rend());

        // vector<vector<int>> dp(n+1,vector<int>(m+1,0));
        vector<int> prev(n+1,0);

        for(int i=1;i<=n;i++)
        {
            vector<int>cur(n+1,0);
            for(int j=1;j<=n;j++)
            {
                if(text1[i-1]==text2[j-1])
                cur[j]=1+prev[j-1];
                else 
                cur[j]=max(prev[j],cur[j-1]);
            }
            prev=cur;
        }
        return n-prev[n];
    }
};

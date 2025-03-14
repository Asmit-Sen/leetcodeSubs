class Solution {
public:
int f(int i, int buy, int cap, vector<int> &prices, vector<vector<vector<int>>> &dp)
{
    if(cap==0 || i==prices.size()) return 0;
    if(dp[i][buy][cap]!=-1) return dp[i][buy][cap];

    if(buy)
    return dp[i][buy][cap]=max(f(i+1,0,cap,prices,dp)-prices[i],f(i+1,1,cap,prices,dp));
    else
    return dp[i][buy][cap]=max(f(i+1,1,cap-1,prices,dp)+prices[i],f(i+1,0,cap,prices,dp));
    
}
    int maxProfit(vector<int>& prices) {
        int n=prices.size();
        vector<vector<vector<int>>> dp(n+1, vector<vector<int>>(2, vector<int>(3,0)));

        for(int i=0;i<=n;i++)
        {
            for(int buy=0;buy<=1;buy++)
            {
                for(int cap=0;cap<=2;cap++)
                {
                    if(cap==0 || i==n)
                    dp[i][buy][cap]=0;
                }
            }
        }

        for(int i=n-1;i>=0;i--)
        {
            for(int buy=0;buy<=1;buy++)
            {
                for(int cap=1;cap<=2;cap++)
                {
                        if(buy)
                        dp[i][buy][cap]=max(dp[i+1][0][cap]-prices[i],dp[i+1][1][cap]);
                        else
                        dp[i][buy][cap]=max(dp[i+1][1][cap-1]+prices[i],dp[i+1][0][cap]);
                }
            }
        }
        return dp[0][1][2];
    }
};

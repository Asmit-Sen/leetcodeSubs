class Solution {
public:
int f(int i, int buy, vector<int> &prices, vector<vector<int>> &dp)
{
    if(i==prices.size()-1) 
    {
        if(buy) return 0;
        return prices[prices.size()-1];
    }
    if(dp[i][buy]!=-1) return dp[i][buy];

    int profit=0;
    if(buy)
    profit=max(f(i+1,0,prices,dp)-prices[i],f(i+1,1,prices,dp));
    else
    profit=max(f(i+1,1,prices,dp)+prices[i],f(i+1,0,prices,dp));

    return dp[i][buy]=profit;
}
    int maxProfit(vector<int>& prices) {
        int n=prices.size();
        // vector<vector<int>> dp(n, vector<int>(2,0));
        vector<int> prev(2,0), cur(2,0);

        prev[0]=prices[n-1];
        // dp[n-1][1]=0;

        int profit=0;
        for(int i=n-2;i>=0;i--)
        {
            for(int buy=1;buy>=0;buy--)
            {
                if(buy)
                profit=max(prev[0]-prices[i],prev[1]);
                else
                profit=max(prev[1]+prices[i],prev[0]);
                
                cur[buy]=profit;
            }
            prev=cur;
        }
        return prev[1];

    }
};

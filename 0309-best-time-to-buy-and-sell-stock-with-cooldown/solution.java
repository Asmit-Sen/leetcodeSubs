import java.util.*;
class Solution {

    int f(int i, int buy, int prices[], int dp[][])
    {
        if(i>=prices.length) return 0;//check bound properly
        if(dp[i][buy]!=-1) return dp[i][buy];

        if(buy==1)
        return dp[i][buy]=(int)(Math.max(f(i+1,0,prices,dp)-prices[i], f(i+1,1,prices,dp)));
        else
        return dp[i][buy]=(int)(Math.max(f(i+2,1,prices,dp)+prices[i], f(i+1,0,prices,dp)));//note here
    }

    public int maxProfit(int[] prices) {
    int n=prices.length;
    // int dp[][]=new int[n+2][2];
    // for(int[] row:dp)
    // Arrays.fill(row,-1);

    int today[]=new int[2];
    int tomorrow[]=new int[2];
    int day_after_tomorrow[]=new int[2];


    for(int i=n-1;i>=0;i--)
    {
        for(int buy=0;buy<=1;buy++)
        {
            if(buy==1)
            {
                int buy_today=tomorrow[0]-prices[i];
                int not_buy=tomorrow[1];
                today[buy]=(int)Math.max(buy_today,not_buy);
            }
            else
            {
                int sell_today=day_after_tomorrow[1]+prices[i];
                int not_sell=tomorrow[0];
                today[buy]=(int)Math.max(sell_today,not_sell);
            }
        }
        day_after_tomorrow=tomorrow.clone();//note
        tomorrow=today.clone();
    }
    return today[1];
    // return f(0,1,prices,dp);
    }
}

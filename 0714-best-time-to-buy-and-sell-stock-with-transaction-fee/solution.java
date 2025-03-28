class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;

        // int today[]=new int[2];
        // int tomorrow[]=new int[2];

        int today_bought=0, today_skip=0, tom_bought=0, tom_skip=0;

        for(int i=n-1;i>=0;i--)
        {
            int buy_today=tom_skip-prices[i];
            int not_buy=tom_bought;
            today_bought=(int)Math.max(buy_today,not_buy);
        
            int sell_today=tom_bought+prices[i]-fee;
            int not_sell=tom_skip;
            today_skip=(int)Math.max(sell_today,not_sell);

            // tomorrow=today.clone();
            tom_bought=today_bought;
            tom_skip=today_skip;
        }
        return today_bought;
        
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE,p=Integer.MIN_VALUE;
        for (int i=0;i<prices.length;i++)
        {
            min=(int) Math.min(prices[i],min);
            p=(int)Math.max(p,prices[i]-min);
        }
        return p;
    }
}

class Solution {
    public int maxSumDivThree(int[] nums) {
        int dp[]=new int[3];
        for(int num:nums){
            int current[]=dp.clone();
            for(int prevSum:current){
                int currentSum=prevSum+num;
                int rem=currentSum%3;
                dp[rem]=(int)Math.max(dp[rem],currentSum);
            }
        }
        return dp[0];
    }
}

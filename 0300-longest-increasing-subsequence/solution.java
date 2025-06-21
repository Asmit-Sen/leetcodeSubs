class Solution {
    int f(int i, int prev, int nums[], int dp[][]){
        if(i==nums.length) return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];

        int take=0,not_take=0;
        not_take=0+f(i+1,prev,nums,dp);
        if(prev==-1 || nums[i]>nums[prev]) take=1+f(i+1,i,nums,dp);

        return dp[i][prev+1]=(int)Math.max(take,not_take);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n+1][n+1];
        for(int row[]:dp)
        Arrays.fill(row,0);


        for(int i=n-1;i>=0;i--){
            for(int prev=i-1;prev>=-1;prev--){
                int take=0, not_take=0;
                not_take=0+dp[i+1][prev+1];
                if(prev==-1 || nums[i]>nums[prev]) take=1+dp[i+1][i+1];
                dp[i][prev+1]=(int)Math.max(take,not_take);
            }
        }

        return dp[0][0];
    }
}

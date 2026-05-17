class Solution {
    int f (int i, int nums[], int dp[]){
        if (i==nums.length-1) return 0;
        if (dp[i]!=-1) return dp[i];

        int mini = (int)1e6;
        for(int j=1;j<=nums[i];j++)
            if ((i+j) < nums.length) mini = Math.min( mini, 1 + f(i+j,nums, dp));

        return dp[i] = mini;
    }
    public int jump(int[] nums) {
        int n = nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp, (int)1e6);

        dp[n-1]=0;
        for(int i=n-2;i>=0;i--){
            for(int j=1;j<=nums[i];j++){
                if (i+j<n) dp[i] = Math.min(dp[i], 1 + dp[i+j]);
            }
        }

        return dp[0];
    }
}

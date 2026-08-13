class Solution {
    Integer f(int l, int r, int nums[], Integer dp[][]){
        if (l==r) return nums[l];
        if (dp[l][r]!=null) return dp[l][r];

        int left = nums[l] - f(l+1, r, nums, dp);
        int right = nums[r] - f(l, r-1, nums, dp);

        return dp[l][r]=Math.max(left, right);
    }
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        Integer dp[][] = new Integer[n][n];

        return f(0, n-1, nums, dp) >= 0;
    }
}

class Solution {
    int f(int arr[], int i, int dp[])
    {
        if(i<0) return 0;
        if(i==0) return arr[0];

        if(dp[i]!=-1) return dp[i];

        return dp[i]=(int)Math.max(arr[i]+f(arr,i-2,dp),f(arr,i-1,dp));
    }
    public int rob(int[] nums) {
        // int dp[]=new int[nums.length+1];
        // Arrays.fill(dp,-1);

        // return f(nums,nums.length-1,dp);

        // dp[0]=nums[0];
        // int pick=0,notpick=0;
        int prev2=0,prev=nums[0],curr=0;

        for(int i=1;i<nums.length;i++)
        {
            curr=(int)Math.max(nums[i]+prev2,prev);

            prev2=prev;
            prev=curr;
        }
        return prev;

    }
}

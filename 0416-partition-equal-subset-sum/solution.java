class Solution {
    // boolean f(int i, int target, int arr[], int dp[][])
    // {
    //     if(dp[i][target]!=-1) return dp[i][target]==1?true:false;
    //     if(target==0) return true;
    //     if(i==0) return arr[0]==target;

    //     boolean not_take=f(i-1,target,arr,dp);
    //     boolean take=false;
    //     if(arr[i]<=target) take=f(i-1,target-arr[i],arr,dp);

    //     dp[i][target]=take||not_take?1:0;
    //     return take||not_take;

    // }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int x:nums)
        sum+=x;
        if(sum%2==1) return false;
        int target=(int)Math.ceil(sum/2);

        boolean dp[][]=new boolean[nums.length][target+1];
        for(boolean row[]:dp)
        Arrays.fill(row,false);

        //base cases
        for(int i=0;i<nums.length;i++)
        {
            dp[i][0]=true;
        }
        if(nums[0]<=target) dp[0][nums[0]]=true;

        for(int i=1;i<nums.length;i++)
        {
            for(int t=1;t<=target;t++)
            {
                boolean not_take=dp[i-1][t];
                boolean take=false;
                if(nums[i]<=t) take=dp[i-1][t-nums[i]];
                dp[i][t]=take||not_take;
            }
        }
        return dp[nums.length-1][target];
    }
}

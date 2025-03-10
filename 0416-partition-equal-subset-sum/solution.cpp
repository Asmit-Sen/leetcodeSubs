class Solution {
public:
    // int f(int i, int target, vector<int> nums, vector<vector<int>>& dp)
    // {
    //     if(target==0) return true;
    //     if(i==0) return nums[0]==target;
    //     if(dp[i][target]!=-1) return dp[i][target];

    //     return dp[i][target]=f(i-1,target,nums,dp) | (target>=nums[i]?f(i-1,target-nums[i],nums,dp):0);
    // }
    bool canPartition(vector<int>& nums) {
        int sum=0;
        for(int x:nums)
        sum+=x;

        if(sum&1)//odd
        return false;

        int target=sum/2;
        int n=nums.size();
        vector<vector<int>> dp(n,vector<int>(target+1,0));
        // return f(n-1,sum/2,nums,dp);

        vector<int> prev(target+1,0);
        prev[0]=1;

        // for(int i=0;i<n;i++)
        // dp[i][0]=1;

        if(nums[0]<=target) dp[0][nums[0]]=1;

        for(int i=1;i<n;i++)
        {
            vector<int> cur(target+1,0);
            cur[0]=1;
            for(int t=1;t<=target;t++)
            {
                cur[t]=prev[t] | ((t>=nums[i])?prev[t-nums[i]]:0);
            }
            prev=cur;
        }
        return prev[target];


    }
};

class Solution {
    int f(int arr[], int idx, int dp[])
    {
        if(idx==0) return arr[0];
        if(dp[idx]!=-1) return dp[idx]; //memo
        
        // take
        int l=arr[idx];
        if(idx>1) l+=f(arr,idx-2,dp);

        //not take
        int r=f(arr,idx-1,dp);

        return dp[idx]=(int)Math.max(l,r); //memo
    }
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);

        return f(nums,nums.length-1,dp);
    }
}

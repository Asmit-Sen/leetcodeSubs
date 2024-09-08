class Solution {
    // int jump(int arr[], int idx, int jump, int dp[][])
    // {
    //     if(idx>=arr.length-1) return jump;

    //     if(dp[idx][jump]!=-1)
    //     return dp[idx][jump];

    //     int mini=Integer.MAX_VALUE;
    //     for(int i=1;i<=arr[idx];i++)
    //     {
    //         mini=(int)Math.min(mini,jump(arr,idx+i,jump+1,dp));
    //     }
    //     return dp[idx][jump]=mini;
    // }
    // public int jump(int[] nums) {
    //     int n=nums.length;
    //     int dp[][]=new int[n][n];
    //     for(int row[]:dp)
    //     Arrays.fill(row,-1);

    //     return jump(nums, 0, 0, dp);
    // }
    public int jump(int[] arr) {

        int jumps=0,l=0,r=0,n=arr.length;
        while(r<n-1){
            int maxi=0;
            for(int i=l;i<=r;i++)
                maxi=(int)Math.max(maxi,i+arr[i]);
            l=r+1;
            r=maxi;
            jumps++;
        }
        return jumps;
    }
}

class Solution {
    public int minPairSum(int[] nums) {
        // 3 4 4 6 6 6 = 10

        // 2 3 4 4 5 6 = 8

        Arrays.sort(nums);
        int ans=0, n=nums.length;
        for(int i=0;i<n/2;i++){
            if(nums[i]+nums[n-i-1]>=ans)
            ans=nums[i]+nums[n-i-1];
        }

        return ans;
    }
}

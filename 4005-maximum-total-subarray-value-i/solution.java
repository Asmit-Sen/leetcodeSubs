class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long maxi=nums[0], mini=nums[0];
        for(int x: nums){
            maxi=(int)Math.max(maxi,x);
            mini=(int)Math.min(mini,x);
        }
        return (long) k*(maxi-mini);
    }
}

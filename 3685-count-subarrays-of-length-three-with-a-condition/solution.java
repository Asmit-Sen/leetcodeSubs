class Solution {
    public int countSubarrays(int[] nums) {
        int cnt=0;
        int l=0,r=2;
        while(r<nums.length){
            if(nums[l]+nums[r]==nums[r-1]/2.0) cnt++;
            l++;
            r++;
        }
        return cnt;
    }
}

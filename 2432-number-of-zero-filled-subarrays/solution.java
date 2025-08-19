class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n=nums.length;
        int l=0,r=0;
        long ans=0;
        while(r<n){
            if(nums[r]==0) ans+=r-l+1;
            else l=r+1;
            r++; 
        }
        return ans;
    }
}

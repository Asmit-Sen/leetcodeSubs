class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxi=0;
        for(int num:nums)
        maxi=(int)Math.max(maxi,num);

        long cnt=0,c=0; 
        int l=0,r=0;
        while(r<nums.length){
            if(nums[r]==maxi) c++;
            while(c>=k){
                cnt+=nums.length-r;
                if(nums[l]==maxi) c--;
                l++;
            }
            r++;
        }
        return cnt;        
    }
}

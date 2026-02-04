class Solution {
    public boolean isTrionic(int[] nums) {
        int peak = 0, ditch = 0;
        for(int i=1; i< nums.length-1; i++){
            if (nums[i]>nums[i-1] && nums[i]> nums[i+1])
                if(ditch!=0)
                    return false;
                else peak++;
            if (nums[i]<nums[i-1] && nums[i]< nums[i+1])
                if(peak==0)
                    return false;
                else ditch++;
            if(nums[i]==nums[i-1] || nums[i]==nums[i+1]) return false;
        }   
        return peak==1 && ditch==1;
    }
}

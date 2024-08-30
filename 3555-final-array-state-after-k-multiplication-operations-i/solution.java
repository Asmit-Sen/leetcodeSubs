class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for(int j=0;j<k;j++)
        {
            int mini=nums[0],pos=0;
            for(int i=0;i<nums.length;i++)
            {
                if(nums[i]<mini)
                {
                    mini=nums[i];
                    pos=i;
                }
            }
            nums[pos]*=multiplier;
        }
        return nums;
    }
}

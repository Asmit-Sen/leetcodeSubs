class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxi=0,l=0,r=0;

        while(r<nums.length)
        {
            if(nums[r]==0)
            k--;
            while(k<0)
            {
                if(nums[l]==0)
                    k++;
                l++;
            }
            maxi=(int)Math.max(maxi,r-l+1);
            r++;
        }
        return maxi;
    }
}

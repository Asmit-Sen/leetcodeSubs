class Solution {
    public int majorityElement(int[] nums) {
        int m=nums[0];
        int c=0,max=0;
        int max_el=-1;
        for (int it:nums)
        {
            
            if (c==0) m=it;
            if(it==m) c++;
            else c--;
        }
        if(c>0) max_el=m;
        int count=0;
        for (int it:nums)
        if(it==max_el) count++;
        if(count>nums.length/2) return max_el;
        else return -1;


    }
}

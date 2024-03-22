class Solution {
    public int searchInsert(int[] nums, int target) {
        int f=0,l=nums.length-1,mid=-1;
        while(f<=l)
        {
            mid=f+(l-f)/2;
            if(nums[mid]==target) return mid;
            else if (target<nums[mid]){l=mid-1;}
            else f=mid+1;
           
        }
        return f;
    }
}

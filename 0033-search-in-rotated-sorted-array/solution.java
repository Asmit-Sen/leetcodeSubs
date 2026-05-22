class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, h = n-1;

        while(l<=h){
            int mid = l + ( h - l) / 2;
            if (target==nums[mid]) return mid;
            if (nums[l]<=nums[mid]){
                // left half sorted
                if (target>=nums[l] && target<=nums[mid]) h=mid-1;
                else l=mid+1;
            }
            else{
                // right half sorted
                if (target>=nums[mid] && target<=nums[h]) l=mid+1;
                else h=mid-1;
            }
        }
        return -1;
    }
}

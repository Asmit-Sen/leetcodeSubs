class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        // Arrays.sort(nums);
        // return Math.max((nums[0] - 1 )* (nums[1]-1), (nums[n-1]-1) * (nums[n-2]-1));

        int l=0, sl=0;
        for(int x : nums){
            if (x>=l){
                sl=l;
                l=x;
            }
            else if (x>sl) sl=x;
        }
        return (l-1)*(sl-1);
    }
}

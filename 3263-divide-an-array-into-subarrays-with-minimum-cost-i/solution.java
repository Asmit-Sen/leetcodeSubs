class Solution {
    public int minimumCost(int[] nums) {
        // 4,3,2,1,1,2,3
        int n = nums.length;
        int x = (int)1e9, y = (int)1e9;

        for(int i=1;i<n;i++){
            if (nums[i] < x){
                y = x;
                x = nums[i];
            }
            else if (nums[i] < y){
                y = nums[i];
            }
        }

        return nums[0] + x + y;
    }
}

class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        int n=nums.length;
        for(int x:nums){
            if(x==original) original*=2;
            // if(x<original) continue;
            // else break;
        }
        return original;
    }
}

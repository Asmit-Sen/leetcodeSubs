class Solution {
    public int[] concatWithReverse(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n*2];

        for(int i=0;i<n;i++){
            ans[i]=nums[i];
            ans[2*n-i-1]=nums[i];
        }

        return ans;
    }
}

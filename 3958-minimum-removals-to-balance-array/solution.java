class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int l=0, r=0;
        int n=nums.length;
        int ans=(int)-1e9;
        while(r<n){
            if (nums[r]<=(long)k*nums[l]) {
                ans=(int)Math.max(ans, r-l+1);
                r++;
            }
            else{
                l++;
            }
        }
        return n-ans;
    }
}

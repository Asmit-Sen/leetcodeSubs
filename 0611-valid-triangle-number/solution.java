class Solution {
    public int triangleNumber(int[] nums) {
        int c=0;
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=n-1;i>=0;i--){
            int l=0, r=i-1;

            while(l<r){
                if(nums[l]+nums[r]>nums[i]) 
                {
                    c+=(r-l);
                    r--;
                }
                else
                l++;
            }
        }
        return c;
    }
}

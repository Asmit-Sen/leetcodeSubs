class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;

        long prefix[]=new long[n];
        prefix[0]=0;
        
        for(int i=1;i<n;i++){
            prefix[i]=nums[i-1]+prefix[i-1];
        }
        for(int i=n-1;i>=0;i--){
            if(prefix[i]>nums[i]) return (long) prefix[i]+nums[i];
        }
        return -1;
    }
}

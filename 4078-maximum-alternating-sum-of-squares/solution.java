class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        //ele with highest abs value at the even places
        for(int i=0;i<n;i++){
            nums[i]=(int)Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        int even = (n+1)/2 , odd=n/2;
        long ans=0;

        int p=0;
        while(odd-->0){
            ans-=Math.pow(nums[p++],2);
        }
        while(even-->0){
            ans+=Math.pow(nums[p++],2);
        }

        return ans;
    }
}

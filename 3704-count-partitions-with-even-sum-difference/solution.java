class Solution {
    public int countPartitions(int[] nums) {
        int ans=0;
        int n=nums.length;
        int pre[]=new int[n];

        pre[0]=nums[0];
        for(int i=1;i<n;i++) pre[i]=pre[i-1]+nums[i];

        for(int i=0;i<n-1;i++){
            if ((pre[n-1]-2*pre[i])%2==0) ans++;
        }
        return ans;
    }
}

class Solution {
    public int maxRotateFunction(int[] nums) {
        long sum = 0, maxi = Long.MIN_VALUE;
        int n = nums.length;

        for (int x: nums) sum+=x;
        long curr = 0;

        for(int i=0;i<n;i++){
            curr += nums[i]*i;
        }
        maxi = Math.max(maxi, curr);

        for(int i=1;i<n;i++){
            curr = curr + sum - (long)(n * nums[n-i]);
            maxi = (long)Math.max(maxi, curr);
        }

        return (int)maxi;
    }
}

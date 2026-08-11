class Solution {
    public int missingInteger(int[] nums) {
        if (nums.length==1) return nums[0]+1;
        int f[]=new int[2501];

        int sum = nums[0];
        f[nums[0]]=1;
        int n = nums.length;
        int i;
        for(i=1;i<n;i++) {
            f[nums[i]]=1;
            if (nums[i]==nums[i-1]+1) sum+=nums[i];
            else break;
        }
        for(;i<n;i++) f[nums[i]]=1;

        for(int j=sum;j<=2500;j++) if (f[j]==0) return j;

        return -1;


    }
}

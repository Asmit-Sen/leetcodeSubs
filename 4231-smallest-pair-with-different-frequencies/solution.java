class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        int ans[]=new int[2];
        Arrays.fill(ans,-1);
        if(nums.length==0) return ans;

        int f[]=new int[101];
        for(int x:nums) f[x]++;

        for(int i=1;i<=100;i++){
            if (f[i]!=0 && ans[0]==-1) ans[0]=i;
            if (ans[0]!=-1 && f[i]!=0 && f[i]!=f[ans[0]]) {
                ans[1]=i;
                return ans;
            }
        }
        return new int[]{-1,-1};
    }
}

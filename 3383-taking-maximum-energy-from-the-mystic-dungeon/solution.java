class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        for(int i=n-1;i-k>=0;i--){
            energy[i-k]+=energy[i];
        }

        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        ans=(int)Math.max(ans,energy[i]);

        return ans;
    }
}

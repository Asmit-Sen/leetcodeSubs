class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long ans = 0;
        int n = happiness.length;
        int pos = n-1;

        for(int i = 0; i < k; i++){
            ans += (int)Math.max(happiness[pos] - i, 0);
            pos--;
        }
        return ans;
    }
}

class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for(int x:apple) sum+=x;
        if(sum==0) return 0;

        Arrays.sort(capacity);
        int n=capacity.length;
        int ans = 0, cap = 0;
        for(int i=n-1;i>=0;i--){
            cap+=capacity[i];
            if(cap>=sum) return ans+1;
            ans++;
        }
        return ans;
    }
}

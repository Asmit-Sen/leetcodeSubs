class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        if (cost.length==1) return cost[0];
        if (cost.length==2) return cost[0]+cost[1];
        // 1 2 3 4 5
        int ans = 0;
        int n = cost.length;
        for(int i=n-1; i>=0; i--){
            if ((n-i-1)%3==2) continue;
            ans += cost[i];
        }
        return ans;
    }
}

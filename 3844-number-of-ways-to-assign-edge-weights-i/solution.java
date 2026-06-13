class Solution {
    private long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        long maxi = 0;
        long depth[] = new long[n+1];

        int mod = (int)1e9+7;

        Arrays.sort(edges, (a,b)->a[0]-b[0]);

        for (int e[]:edges){
            int x = e[0];  
            int y = e[1];

            int par = Math.min(x,y);
            int child = Math.max(x,y);

            depth[child] = (depth[par] + 1) % mod;
            maxi = (long)Math.max(maxi, depth[child]);
        }

        // return (int)Math.pow(2, maxi-1);
        return (int)power(2,maxi-1, mod);
    }
}

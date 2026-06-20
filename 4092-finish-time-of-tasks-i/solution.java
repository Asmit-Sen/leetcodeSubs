class Solution {
    long dfs(int i, List<List<Integer>> adj, int times[], int vis[]){
        vis[i]=1;

        long mini = Long.MAX_VALUE;
        long maxi = Long.MIN_VALUE;
        
        if (adj.get(i).size()==0) return times[i];
        
        for(int node : adj.get(i)){
            long d = dfs(node, adj, times, vis);
            mini = Math.min(mini, d);
            maxi = Math.max(maxi, d);
        }

        return maxi * 2 - mini + times[i];
    }
    public long finishTime(int n, int[][] edges, int[] baseTime) {

        int vis[]=new int[n];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int e[] : edges)
            adj.get(e[0]).add(e[1]);

        return dfs(0, adj, baseTime, vis);
        
    }
}

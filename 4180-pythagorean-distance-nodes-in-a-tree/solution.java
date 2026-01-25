class Solution {
    void bfs (int node, long dist[], List<List<Integer>> adj, int n){
        Queue<Integer> q = new LinkedList<>();
        int vis[]= new int[n];
        q.offer(node);
        dist[node]=0;
        vis[node]=1;

        while(!q.isEmpty()){
            int top = q.poll();
            for(int nbr : adj.get(top)){
                if (vis[nbr]!=1){
                    q.offer(nbr);
                    vis[nbr]=1;
                    dist[nbr]=dist[top] + 1;
                }
            }
        }
    }
    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        // distance from any node to every other node
        long distx[] = new long[n];
        long disty[] = new long[n];
        long distz[] = new long[n];

        //construct the adjacecy list from edges
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int edge[] : edges){
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // bfs at the target nodes
        bfs(x, distx, adj, n);
        bfs(y, disty, adj, n);
        bfs(z, distz, adj, n);

        // check for triplets
        int ans=0;
        for(int i=0;i<n;i++){
                long dx = distx[i];
                long dy = disty[i];
                long dz = distz[i];

                List<Long>list = new ArrayList<>();
                list.add(dx);
                list.add(dy);
                list.add(dz);
                Collections.sort(list);

                long a = (long)Math.pow(list.get(0),2);
                long b = (long)Math.pow(list.get(1),2);
                long c = (long)Math.pow(list.get(2),2);
                
                if(a+b==c) ans++;
        }
        return ans;
    }
}

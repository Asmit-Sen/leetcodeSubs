class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        for(int e[] : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];

            adj.get(u).add(new int[]{v,w});

            adj.get(v).add(new int[]{u, 2*w});
        }

        //dijsktras on the graph with modified paths

        PriorityQueue<int[]> pq = new PriorityQueue<>
        ((a,b)-> a[1]-b[1]);
        // (node, dist)

        int dist[] = new int[n];
        Arrays.fill(dist, (int)1e9);

        pq.offer(new int[]{0,0});
        dist[0]=0;

        while(!pq.isEmpty()){
            int top[] = pq.poll();
            int node = top[0];
            int curr = top[1];

            for(int nbrNode[] : adj.get(node)){
                int nbr = nbrNode[0];
                int wt = nbrNode[1];

                if (curr + wt < dist[nbr]){
                    dist[nbr] = curr+wt;
                    pq.offer(new int[]{nbr, dist[nbr]});
                }
            }
        }
        return dist[n-1]==(int)1e9 ? -1 : dist[n-1];
    }
}

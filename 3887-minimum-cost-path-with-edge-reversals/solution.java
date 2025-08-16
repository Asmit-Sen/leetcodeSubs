class Solution {
    public int minCost(int n, int[][] edges) {
        //construct the adjacency list
        List<List<List<Integer>>> adj = new ArrayList<>();

        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            //{v,w}
            List<Integer> dest = new ArrayList<>();
            dest.add(v);
            dest.add(w);
            // {u->{{v,w},{},{}}}
            adj.get(u).add(dest);
            
            List<Integer> rev = new ArrayList<>();
            rev.add(u);
            rev.add(w*2);
            adj.get(v).add(rev);
        }


        //dijkstras
        //{distance, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int dist[]=new int[n];

        pq.offer(new int[]{0,0});
        Arrays.fill(dist,(int)1e9);
        dist[0]=0;

        while(!pq.isEmpty()){
            int top[]=pq.peek();
            pq.poll();

            int d=top[0];
            int node=top[1];

            for(List<Integer> nbr : adj.get(node)){
                int destination = nbr.get(0);
                int edgew = nbr.get(1);

                if(d+edgew<dist[destination]){
                    dist[destination]=d+edgew;
                    pq.offer(new int[]{dist[destination], destination});
                }
            }
        }

        return dist[n-1]==(int)1e9?-1:dist[n-1];
    }
}

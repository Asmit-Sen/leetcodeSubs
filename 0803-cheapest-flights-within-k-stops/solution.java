class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj= new ArrayList<>();
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<>());

        for(int flight[]: flights){
            int u=flight[0], v=flight[1], price=flight[2];
            adj.get(u).add(new int[]{v,price});
        }

        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[1]-b[1]);
        // Queue<int[]> pq= new LinkedList<>();
        int dist[] =new int[n];

        pq.offer(new int[]{src,0,0}); // node, stops, price
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;

        while(!pq.isEmpty()){
            int node=pq.peek()[0];
            int stops=pq.peek()[1];
            int priceTillNow=pq.peek()[2];
            pq.poll();

            if(stops>k) continue;

            for(int city[]: adj.get(node)){
                int nbr=city[0];
                int price=city[1];

                if(priceTillNow+price<dist[nbr] && stops<=k){
                    dist[nbr]=priceTillNow+price;
                    pq.offer(new int[]{nbr,stops+1,dist[nbr]});
                }
            }
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
        //A better and cheaper route might still be in the queue with valid stops. You must let the queue finish
        // exploring all valid paths.
    }
}

class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n+1;i++) adj.add(new ArrayList<>());

        for(int edge[]: roads){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }

        int d[]=new int[n+1];
        Arrays.fill(d, (int)1e9);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        pq.offer(new int[]{1, d[1]});

        while(!pq.isEmpty()){
            int top[]=pq.poll();
            int i = top[0];
            int cur = top[1];

            for(int nbr[] : adj.get(i)){
                if (Math.min(cur, nbr[1]) < d[nbr[0]]){
                    d[nbr[0]] = Math.min(cur, nbr[1]);
                    pq.offer(new int[]{nbr[0], d[nbr[0]]});
                }
            }
        }

        return d[n];
    }
}

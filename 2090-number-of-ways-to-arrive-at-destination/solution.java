class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj= new ArrayList<>();
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<>());

        for(int time[]: roads){
            int u=time[0], v=time[1], price=time[2];
            adj.get(u).add(new int[]{v,price});
            adj.get(v).add(new int[]{u,price});
        }

        PriorityQueue<long[]> pq= new PriorityQueue<>(Comparator.comparingLong(a->a[0]));
        long dist[]=new long[n];
        long paths[]=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        Arrays.fill(paths,0);
        
        pq.offer(new long[]{0,0});
        dist[0]=0;
        paths[0]=1;
        long mod=(long)1e9+7;

        while(!pq.isEmpty()){
            long timeTillNow=pq.peek()[0];
            int cur=(int)pq.peek()[1];
            pq.poll();

            for(int it[]: adj.get(cur)){
                int nbr=it[0];
                int time=it[1];
                if(timeTillNow+time<dist[nbr]){
                    paths[nbr]=paths[cur];
                    dist[nbr]=timeTillNow+time;
                    pq.offer(new long[]{dist[nbr],nbr});
                }
                else if(timeTillNow+time==dist[nbr]) 
                paths[nbr]=(paths[nbr]+paths[cur])%mod;
            }
        }
        return (int)paths[n-1];
    }
}

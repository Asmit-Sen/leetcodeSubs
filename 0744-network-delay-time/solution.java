class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj= new ArrayList<>();
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<>());

        for(int time[]: times){
            int u=time[0]-1, v=time[1]-1, price=time[2];
            adj.get(u).add(new int[]{v,price});
        }

        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[0]-b[0]);
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        pq.offer(new int[]{0,k-1});
        dist[k-1]=0;

        while(!pq.isEmpty()){
            int timeTillNow=pq.peek()[0];
            int cur=pq.peek()[1];
            pq.poll();

            for(int it[]: adj.get(cur)){
                int nbr=it[0];
                int time=it[1];
                if(timeTillNow+time<dist[nbr]){
                    dist[nbr]=timeTillNow+time;
                    pq.offer(new int[]{dist[nbr],nbr});
                }
            }
        }

        int ans=Integer.MIN_VALUE;
        for(int time:dist)
        ans=(int)Math.max(ans,time);

        return ans==Integer.MAX_VALUE?-1:ans;
    }
}

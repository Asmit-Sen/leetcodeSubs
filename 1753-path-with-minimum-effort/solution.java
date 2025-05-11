class Solution {
    public int minimumEffortPath(int[][] grid) {
        PriorityQueue <int[]> pq=new PriorityQueue<>((a,b)-> a[2]-b[2]);
        int n=grid.length, m=grid[0].length;
        int dist[][]=new int[n][m];

        pq.offer(new int[]{0,0,0}); //effort,r,c
        for(int row[]:dist)
        Arrays.fill(row,Integer.MAX_VALUE);
        dist[0][0]=0;

        int dx[]={0,0,-1,1};
        int dy[]={1,-1,0,0};

        while(!pq.isEmpty()){
            int r=pq.peek()[0];
            int c=pq.peek()[1];
            int effortTillNow=pq.peek()[2];
            pq.poll();

            if(r==n-1 && c==m-1) return effortTillNow;

            for(int i=0;i<4;i++){
                int newr= r+dx[i];
                int newc= c+dy[i];
                if(newr>=0 && newc>=0 && newr<n && newc<m){
                    int diff=(int)Math.abs(grid[r][c]-grid[newr][newc]);
                    int newEffort=(int)Math.max(effortTillNow, diff);
                    if(newEffort<dist[newr][newc]){
                        dist[newr][newc]=newEffort;
                        pq.offer(new int[]{newr,newc,newEffort});
                    }
                }
            }
        }
        // return dist[n-1][m-1];
        return -1;
    }
}

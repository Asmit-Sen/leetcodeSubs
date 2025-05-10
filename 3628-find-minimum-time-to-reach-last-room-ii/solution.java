class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n=moveTime.length, m=moveTime[0].length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> a[2]-b[2]);
        int dist[][]=new int[n][m];
        for(int row[]:dist)
        Arrays.fill(row,Integer.MAX_VALUE);

        int dx[]=new int[]{0,0,-1,1};
        int dy[]=new int[]{-1,1,0,0};

        pq.offer(new int[]{0,0,0,1});
        dist[0][0]=0;
        
        while(!pq.isEmpty()){
            int x=pq.peek()[0];
            int y=pq.peek()[1];
            int timetillnow=pq.peek()[2];
            int steps=pq.peek()[3];
            pq.poll();

            // if(timetillnow>dist[x][y]) continue;
            if(x==n-1 && y==m-1) return timetillnow;

            for(int i=0;i<4;i++){
                int xx=x+dx[i];
                int yy=y+dy[i];

                if(xx>=0 && yy>=0 && xx<n && yy<m && (int)Math.max(timetillnow,moveTime[xx][yy])+steps<dist[xx][yy]){
                    dist[xx][yy]=(int)Math.max(timetillnow,moveTime[xx][yy])+steps;
                    pq.offer(new int[]{xx,yy,dist[xx][yy],steps^1^2});
                }
            }
        }
        return -1;
    }
}

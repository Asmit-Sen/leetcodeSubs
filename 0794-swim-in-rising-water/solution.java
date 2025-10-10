class Solution {
    boolean isValid(int i, int j, int n){
        return (i>=0 && j>=0 && i<n && j<n);
    }
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int n=grid.length;
        int dist[][]=new int[n][n];
        int vis[][]=new int[n][n];

        for(int row[]:dist)
            Arrays.fill(row,(int)1e9);
        dist[0][0]=grid[0][0];
        vis[0][0]=1;

        int dx[]={1,-1,0,0};
        int dy[]={0,0,1,-1};

        q.offer(new int[]{grid[0][0],0,0});

        while(!q.isEmpty()){
            int top[]=q.poll();
            int d=top[0];
            int r=top[1], c=top[2];

            vis[r][c]=1;

            if(r==n-1 && c==n-1) return dist[r][c];

            for(int dir=0;dir<4;dir++){
                int rr= r+dx[dir];
                int cc= c+dy[dir];

                if(isValid(rr,cc,n) && vis[rr][cc]!=1){
                    int wt=(int)Math.max(d,grid[rr][cc]);

                    if(wt<dist[rr][cc]){
                        dist[rr][cc]=wt;
                        q.offer(new int[]{dist[rr][cc],rr,cc});
                    }
                }
            }
        }

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(dist[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        return -1;
    }
}

class Solution {
    boolean valid (int i, int j, int n){
        return (i>=0 && j>=0 && i<n && j<n);
    }
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[2]-b[2]);
        int dx[] = {0,0,-1,1};
        int dy[] = {1,-1,0,0};

        int n = grid.length;
        int vis[][] = new int[n][n];

        for(int row[] : vis) Arrays.fill(row, 0);

        pq.offer(new int[]{0,0, grid[0][0]});
        vis[0][0]=1;

        int ans =(int)1e9;
        while(!pq.isEmpty()){
            int top[]= pq.poll();
            int i = top[0];
            int j = top[1];
            int curr_time = top[2];

            if (i==n-1 && j==n-1) ans =(int)Math.min(ans, curr_time);
            for(int dir = 0; dir<4;dir++){
                int ii = i + dx[dir];
                int jj = j + dy[dir];

                if (valid(ii,jj,n) && vis[ii][jj]==0){
                    vis[ii][jj]=1;
                    pq.offer(new int[]{ii,jj,(int)Math.max(grid[ii][jj], curr_time)});
                }
            }
        }
        return ans;
    }
}

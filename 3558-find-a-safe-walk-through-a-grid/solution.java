class Solution {
    boolean valid(int i, int j, int n, int m){
        return i>=0 & j>=0 && i<n && j<m;
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();
        int d[][]=new int[n][m];
        for(int row[]: d) Arrays.fill(row, (int)1e9);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.offer(new int[]{0,0,grid.get(0).get(0)});
        d[0][0]=0;

        int dx[]={0,0,-1,1};
        int dy[]={-1,1,0,0};

        while(!pq.isEmpty()){
            int top[]=pq.poll();
            int i = top[0], j = top[1], cur = top[2];

            for(int dir = 0; dir<4; dir++){
                int ii = i + dx[dir];
                int jj = j + dy[dir];

                if(valid(ii,jj,n,m)){
                    if (cur + grid.get(ii).get(jj) < d[ii][jj]){
                        d[ii][jj] = cur + grid.get(ii).get(jj);
                        pq.offer(new int[]{ii,jj, d[ii][jj]});
                    }
                }
            }
        }

        return d[n-1][m-1]<health;
    }
}

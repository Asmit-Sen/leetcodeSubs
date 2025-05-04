class Solution {
    boolean isValid(int i, int j, int n, int m){
        return (i >= 0 && j >= 0 && i < n && j < m);
    }

    int bfs(int[][] grid, int[][] vis){
        int dx[] = {0, 0, 1, -1, 1, 1, -1, -1};
        int dy[] = {1, -1, 0, 0, 1, -1, 1, -1};

        int n = grid.length, m = grid[0].length;

        if(grid[0][0] == 1 || grid[n - 1][m - 1] == 1) return -1;

        vis[0][0] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1}); // i, j, dist (start counting from 1)

        while(!q.isEmpty()){
            int i = q.peek()[0];
            int j = q.peek()[1];
            int dist = q.peek()[2];
            q.poll();

            if(i == n - 1 && j == m - 1) return dist;

            for(int dir = 0; dir < 8; dir++){
                int ii = i + dx[dir];
                int jj = j + dy[dir];
                if(isValid(ii, jj, n, m) && vis[ii][jj] == 0 && grid[ii][jj] == 0){
                    q.offer(new int[]{ii, jj, dist + 1});
                    vis[ii][jj] = 1;
                }
            }
        }
        return -1;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];
        return bfs(grid, vis);
    }
}


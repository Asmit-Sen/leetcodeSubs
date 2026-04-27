class Solution {
    boolean valid(int i, int j, int n, int m){
        return i>=0 && j>=0 && i<n && j<m;
    }
    public boolean hasValidPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int vis[][] = new int[n][m];
        HashMap<Integer, int[]> map = new HashMap<>();
        map.put(1, new int[]{ 0,-1,0,1 }); 
        map.put(2, new int[]{ -1,0,1,0 }); 
        map.put(3, new int[]{ 0,-1,1,0 }); 
        map.put(4, new int[]{ 0,1,1,0 }); 
        map.put(5, new int[]{ -1,0,0,-1}); 
        map.put(6, new int[]{ -1,0,0,1 }); 

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        vis[0][0]=1;

        while(!q.isEmpty()){
            int top[]=q.poll();
            int i = top[0];
            int j = top[1];

            if (i==n-1 && j==m-1) return true;

            int ii, jj=0;
            int dx1=map.get(grid[i][j])[0];
            int dy1=map.get(grid[i][j])[1];
            ii = i + dx1;
            jj = j + dy1;
            if(valid(ii,jj,n,m) && vis[ii][jj]!=1){
                if (((map.get(grid[ii][jj])[0] + dx1 == 0) && (map.get(grid[ii][jj])[1] + dy1 ==0)) ||
                    ((map.get(grid[ii][jj])[2] + dx1 == 0) && (map.get(grid[ii][jj])[3] + dy1 ==0)))
                        {
                            vis[ii][jj]=1;
                            q.offer(new int[]{ii,jj});    
                        }
            }
            
            int dx2=map.get(grid[i][j])[2];
            int dy2=map.get(grid[i][j])[3];
            ii = i + dx2;
            jj = j + dy2;
            if(valid(ii,jj,n,m) && vis[ii][jj]!=1){
                if (((map.get(grid[ii][jj])[0] + dx2 == 0) && (map.get(grid[ii][jj])[1] + dy2 ==0)) ||
                    ((map.get(grid[ii][jj])[2] + dx2 == 0) && (map.get(grid[ii][jj])[3] + dy2 ==0)))
                        {
                            vis[ii][jj]=1;
                            q.offer(new int[]{ii,jj});    
                        }
            }
        }
        return false;
    }
}

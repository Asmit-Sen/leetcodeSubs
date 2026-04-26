class Solution {
    boolean valid(int i, int j, int n, int m){
        return i>=0 && j>=0 && i<n & j<m;
    }
    boolean dfs(int i, int j, int pi, int pj,int dx[], int dy[],  int n, int m, int vis[][], char grid[][]){
        if (vis[i][j]==1) return true;
        vis[i][j]=1;

        for(int dir=0; dir<4; dir++){
            int ii=i+dx[dir];
            int jj=j+dy[dir];

            if (valid(ii,jj,n,m) && !(pi==ii && pj==jj) && grid[ii][jj]==grid[i][j])
                if (dfs(ii, jj, i, j, dx, dy, n, m, vis, grid)) return true;
        }
        return false;
    }
    public boolean containsCycle(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int vis[][]=new int[n][m];

        int dx[]={0,0,-1,1};
        int dy[]={-1,1,0,0};

        boolean res = false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (vis[i][j]!=1){
                    res = dfs(i,j,-1,-1,dx,dy,n,m,vis,grid);
                    if (res) return res;
                }
            }
        }
        return false;
    }   
}

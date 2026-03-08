class Solution {
    boolean isValid(int i, int j, int n , int m){
        return (i>=0 && j>=0 && i<n & j<m);
    }

    int dx[]={0,0,-1,1};
    int dy[]={-1,1,0,0};
    
    void dfs(int i, int j, char grid[][], int vis[][], int n, int m){
        vis[i][j]=1;
        for(int dir=0; dir<4; dir++){
            int r = i + dx[dir];
            int c = j + dy[dir];

            if (isValid(r,c,n,m) && vis[r][c]==0 && grid[r][c]=='1')
                dfs(r,c,grid,vis,n,m);
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int ans=0;
        int vis[][]=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (vis[i][j]==0 && grid[i][j]=='1'){
                    ans++;
                    dfs(i,j,grid,vis,n,m);
                }
            }
        }

        return ans;
    }
}

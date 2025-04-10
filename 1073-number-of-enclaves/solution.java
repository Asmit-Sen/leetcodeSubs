class Solution {
    boolean isValid(int i, int j, int m, int n){
        return (i>=0 && i<m && j>=0 && j<n);
    }
    void dfs(int x, int y, int dx[], int dy[], int vis[][], int[][] arr){
        //this is a O on the border
        // dfs for any connected O inside
        vis[x][y]=1;
        for(int i=0;i<4;i++){
            int nx=x+dx[i], ny=y+dy[i];
            if(isValid(nx,ny,arr.length,arr[0].length) && vis[nx][ny]==0 && arr[nx][ny]==1){
                dfs(nx,ny,dx,dy,vis,arr);
            }
        }
    }
    public int  numEnclaves(int[][] board) {
        //traverse border and dfs on all O lying on the border
        // mark dfs path from border as 0
        //1 -> leave it as O
        //0-> turn into X
        int m=board.length, n=board[0].length;
        int dx[]={0,0,1,-1};
        int dy[]={1,-1,0,0};
        int vis[][]=new int[m][n];
        
        int bound_ones=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1){
                    bound_ones++;
                    if(i==0 || i==m-1 || j==0 || j==n-1){
                        dfs(i,j,dx,dy,vis,board);
                    }
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==1){
                    bound_ones--;
                }            }
        }
        return bound_ones;
    }
}

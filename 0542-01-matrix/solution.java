class pair{
    int i,j;
    pair(int i, int j){
        this.i=i;
        this.j=j;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length, n=mat[0].length;
        Queue<pair> q= new LinkedList<>();
        int vis[][]=new int[m][n];
        int dist[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    vis[i][j]=1;
                    dist[i][j]=0;
                    q.offer(new pair(i,j));
                }
            }
        }
        int dx[]={0,0,-1,1};
        int dy[]={1,-1,0,0};
        while(!q.isEmpty()){
            int i=q.peek().i;
            int j=q.peek().j;
            q.poll();
            for(int dir=0;dir<4;dir++){
                int ii=i+dx[dir];
                int jj=j+dy[dir];

                if(ii>=0 && ii<m && jj>=0 && jj<n && vis[ii][jj]==0){
                    q.offer(new pair(ii,jj));
                    vis[ii][jj]=1;
                    dist[ii][jj]=dist[i][j]+1;
                }
            }

        }
        return dist;
    }
}

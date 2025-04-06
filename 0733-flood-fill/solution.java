class Solution {
    void bfs(int i, int j, int[][]image, int color,int dx[], int dy[], int target){
        image[i][j]=color;
        for(int dir=0;dir<4;dir++){
            int ii=i+dx[dir];
            int jj=j+dy[dir];

            if(ii<0 || ii>=image.length || jj<0 || jj>=image[0].length || 
            image[ii][jj]==color || image[ii][jj]!=target) continue;
            bfs(ii,jj,image,color,dx,dy,target);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int dx[]={0,0,-1,1};
        int dy[]={1,-1,0,0};

        bfs(sr,sc,image,color,dx,dy,image[sr][sc]);
        return image;
        
    }
}

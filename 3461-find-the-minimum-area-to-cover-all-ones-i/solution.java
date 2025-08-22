class Solution {
    public int minimumArea(int[][] grid) {
        int minrow=(int)1e9, mincol=(int)1e9, maxrow=0, maxcol=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    minrow=(int)Math.min(minrow,i);
                    mincol=(int)Math.min(mincol,j);
                    maxrow=(int)Math.max(maxrow,i);
                    maxcol=(int)Math.max(maxcol,j);
                }
            }
        }
        return (maxrow-minrow+1)*(maxcol-mincol+1);
    }
}

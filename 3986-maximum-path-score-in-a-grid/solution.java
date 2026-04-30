class Solution {
    int f(int i, int j, int k, int grid[][], Integer vis[][][]){
        if (i<0 || j<0 || k<0) return (int)-1e6;
        if(i==0 && j==0) {
            k = grid[i][j]!=0 ? k-1 : k;
            return k<0 ? (int)-1e6 : grid[i][j];
        }
        
        if (vis[i][j][k]!=null) return vis[i][j][k];

        int up = (int)-1e6, left = (int)-1e6;
        int new_k = grid[i][j]!=0 ? k-1 : k;

        up = f(i-1, j, new_k, grid, vis); 
        left = f(i, j-1, new_k, grid, vis); 

        int res = Math.max(up,left);
        return vis[i][j][k] =  res == (int)-1e6 ? res : res + grid[i][j]; 
    }
    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        Integer dp[][][] = new Integer[n][m][k+1];

        int res = f(n-1, m-1, k, grid, dp);
        return res == (int)-1e6 ? -1 : res;
    }
}

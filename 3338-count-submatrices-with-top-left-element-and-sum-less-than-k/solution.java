class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int sum[] = new int[m];
        int ans=0, cur=0;

        for(int i=0;i<n;i++){
            cur = 0;
            for(int j=0;j<m;j++){
                cur += grid[i][j];
                
                sum[j] += cur;
                if(sum[j]<=k) ans++;
            }
        }
        return ans;
    }
}

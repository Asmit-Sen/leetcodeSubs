class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n =grid.length, m=grid[0].length;

        int fx[] = new int[m];
        int fy[] = new int[m];

        int x=0, y=0, ans=0;
        for(int i=0;i<n;i++){
            x=0;
            y=0;
            for(int j=0;j<m;j++){
                x += grid[i][j]=='X'?1:0;
                y += grid[i][j]=='Y'?1:0;

                // update col wise freq of x and y
                fx[j] += x;
                fy[j] += y;

                if (fx[j]==fy[j] && fx[j]>0) ans++;
            }
        }

        return ans;
    }
}

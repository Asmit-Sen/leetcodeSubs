class Solution {
    public int[] findDegrees(int[][] matrix) {
        // sum of rows
        int n = matrix.length;
        int ans[]=new int[n];
        int i=0;
        for(int row[]: matrix){
            for(int x: row) ans[i]+=x;
            i++;
        }
        return ans;
    }
}

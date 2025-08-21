class Solution {
    public int countSquares(int[][] matrix) {
        int sum=0;
        int dp[][]=matrix.clone();
        int n=matrix.length, m=matrix[0].length;
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]==1){
                    dp[i][j]=(int)Math.min((int)Math.min(matrix[i][j-1],matrix[i-1][j]),matrix[i-1][j-1])+1;
                }
            }
        }
        for(int row[]:matrix){
            for(int x:row)
                sum+=x;
        }
        return sum;
    }
}

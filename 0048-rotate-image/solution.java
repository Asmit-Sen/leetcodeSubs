class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for (int i=0;i<n;i++) //tranpose
        {
            for (int j=0;j<n;j++)
            {
                if(j>=i)
                {int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;}
            }
        }

        for (int i=0;i<n;i++)// reversal of rows
        {
            for (int j=0;j<n/2;j++)
            {
                int rev=matrix[i][j];
                matrix[i][j]=matrix[i][n-1-j];
                matrix[i][n-1-j]=rev;
            }
        }
        


    }
}

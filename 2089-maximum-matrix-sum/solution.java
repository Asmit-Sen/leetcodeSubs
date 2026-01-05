class Solution {
    public long maxMatrixSum(int[][] matrix) {
        // find the least abs value k

        // if no of negatives is odd,
        // ans = sum of absolutes - 2 * k

        // else 
        // ans = sum of absolutes

        long sum = 0;
        int mini = (int)1e9, c = 0;
        for(int row [] : matrix){
            for(int x: row){
                if (x<0){
                    c++;
                }
                mini=(int)Math.min(mini,(int)Math.abs(x));
                sum+=(int)Math.abs(x);
            }
        }  

        if ((c&1)==1) return sum - 2 * mini;
        return sum;
    }
}

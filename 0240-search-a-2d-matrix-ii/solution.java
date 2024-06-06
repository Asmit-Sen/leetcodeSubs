class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int row=0,col=arr[0].length-1;
        while(row<arr.length && col>-1)
        {
            if(arr[row][col]==target) return true;
            else if(target<arr[row][col]) col--;
            else row++;
        }
        return false;

    }
}

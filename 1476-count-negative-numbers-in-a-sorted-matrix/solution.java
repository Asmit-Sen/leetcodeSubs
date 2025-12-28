class Solution {
    int bs (int row[], int m){
        int low = 0, high = m - 1;
        int ans=m;
        while(low <= high){
            int mid=(low+high)/2;
            if(row[mid]<0){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return m-ans;
    }
    public int countNegatives(int[][] grid) {
        //  4   3   2  -1
        //  3   2   1  -1
        //  1   1  -1  -2
        // -1  -1  -2  -3

        // bs on each row
        // O ( N log M )

        int ans=0;
        int m=grid[0].length;
        for(int row[]:grid){
            ans+=bs(row,m);
        }
        return ans;
    }
}

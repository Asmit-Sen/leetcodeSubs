class Solution {
    public int findPeakElement(int[] arr) {
        int n=arr.length;
        int low=1,high=arr.length-2;
        if(n==1) return 0;
        //base cases for first and last
        if(arr[0]>arr[1]) return 0;
        if(arr[n-1]>arr[n-2]) return n-1;

        while(low<=high)
        {
            int mid=low+(high-low)/2;
            //peak
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) return mid;

            //left slope
            else if(arr[mid-1]<arr[mid]) low=mid+1;

            // right slope
            else high=mid-1;
        }
        return -1;
    }
}

class Solution {
    int count( int arr[], int max)
    {
        int cnt=1,prev=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]-prev<max) continue;
            else {
                cnt++;
                prev=arr[i];
            }
        }
        return cnt;
    }
    public int maxDistance(int[] arr, int m) {
        Arrays.sort(arr);
        int n=arr.length;
        if(m>n) return -1; //base case
        
        int low=1,high=arr[n-1]-arr[0],mid;
        while(low<=high)
        {
            mid=low+(high-low)/2;
            int cows=count(arr,mid);
            if(cows<m)high=mid-1;
            else low=mid+1;
        }        
        return high;
    }
}

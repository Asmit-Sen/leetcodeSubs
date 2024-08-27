class Solution {
    int count( int arr[], int k)
    {
        if(k<0) return 0;
        int l=0,r=0,sum=0,cnt=0;
        while(r<arr.length)
        {
            sum+=arr[r];
            while(sum>k)
            {
                sum-=arr[l];
                l++;
            }
            cnt+=r-l+1;
            r++;
        }
        return cnt;
    }
    public int numSubarraysWithSum(int[] arr, int k) {
        return count(arr,k)-count(arr,k-1);
        
    }
}

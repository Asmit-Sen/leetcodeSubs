class Solution {
    int count( int arr[], int k)
    {
        if(k<0) return 0;
        int l=0,r=0,odd=0,cnt=0;
        while(r<arr.length)
        {
            if((arr[r]&1)!=0) odd++;
            while(odd>k)
            {
                if((arr[l]&1)!=0)
                odd--;
                l++;
            }
            cnt+=r-l+1;
            r++;
        }
        return cnt;
    }
    public int numberOfSubarrays(int[] arr, int k) {
        return count(arr,k)-count (arr,k-1);
    }
}

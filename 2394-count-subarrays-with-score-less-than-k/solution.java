class Solution {
    long f(int arr[], long k){
        int l=0,r=0;
        long sum=0,cnt=0,len=0;
        while(r<arr.length){
            sum+=arr[r];
            len=r-l+1;
            while(sum*len>=k){
                sum-=arr[l];
                l++;
                len=r-l+1;
            }

            if(sum*len<k) cnt+=len;
            r++;
        }
        return cnt;
    }
    public long countSubarrays(int[] nums, long k) {
        return f(nums,k);
    }
}

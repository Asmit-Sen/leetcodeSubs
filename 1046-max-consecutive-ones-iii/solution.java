class Solution {
    public int longestOnes(int[] arr, int k) {
        int zeroes=0,l=0,r=0,cnt=0;

        while(l<=r && r<arr.length)
        {
            if(arr[r]==0) zeroes++;
            if(zeroes<=k) 
                cnt=(int)Math.max(cnt,r-l+1);
            else
            {
               if(arr[l]==0) zeroes--;
               l++;
            } 
            r++;
        }
        return cnt;

    }
}

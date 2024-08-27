class Solution {
    public int longestOnes(int[] arr, int k) {
        int maxi=0,l=0,r=0,zeroes=0;

        while(r<arr.length)
        {
            if(arr[r]==0)
                zeroes++;
            if(zeroes>k)
            {
                if(arr[l]==0)
                    zeroes--;
                l++;
            }            
            if(zeroes<=k)
                maxi=(int)Math.max(maxi,r-l+1);
            r++;
        }
        return maxi;
    }
}

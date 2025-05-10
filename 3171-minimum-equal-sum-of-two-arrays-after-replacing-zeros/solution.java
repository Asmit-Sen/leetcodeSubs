class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long zeroes1=0, zeroes2=0, sum1=0, sum2=0;
        for(long x:nums1){
            if(x==0) {
                zeroes1++;
                sum1++;
            }
            sum1+=x;
        }

        for(long x:nums2){
            if(x==0) {
                zeroes2++;
                sum2++;
            }
            sum2+=x;
        }

        // if(zeroes1!=0 && zeroes2!=0) return (int)Math.max(sum1,sum2);
        if(zeroes1==0 && zeroes2==0) return sum1==sum2?sum1:-1;
        if(zeroes1==0 && sum1<sum2 || zeroes2==0 && sum2<sum1) return -1;
        return (long)Math.max(sum1,sum2);
    }
}

class Solution {
    public int maxProduct(int[] arr) {
        int max=Integer.MIN_VALUE,left=1,right=1;
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            if(left==0) left=1; // if any element was found zero we start a new subarray 
            if(right==0) right=1; // and set the prod to 1
            left*=arr[i];
            right*=arr[n-1-i];
            max=(int)Math.max(max,left);
            max=(int)Math.max(max,right);
        }
        return max;
    }
}

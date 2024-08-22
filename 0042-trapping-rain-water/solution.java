class Solution {
    public int trap(int[] arr) {
    // water[i]=min(maxL,maxR)-arr[i];
    int water=0, n=arr.length;
    int left=0,right=n-1,maxL=0,maxR=0;
    while(left<right)
    {
        if(arr[left]<arr[right])
        {
            // left water calc with maxL
            if(maxL>arr[left])
            water+=maxL-arr[left];
            else
            maxL=arr[left];
            left++;
        }
        else
        {
            if(maxR>arr[right])
            water+=maxR-arr[right];
            else
            maxR=arr[right];
            right--;
        }       
    }
    return water;
    }
}





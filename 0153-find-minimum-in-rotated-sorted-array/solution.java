class Solution {
    public int findMin(int[] arr) {
        int ans=Integer.MAX_VALUE;
        int low=0,high=arr.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(arr[low]<=arr[mid])//left half sorted
            {
                ans=(int)Math.min(ans,arr[low]);
                low=mid+1;
            } 
            else if(arr[mid]<=arr[high]) // right half sorted
            {
                ans=(int)Math.min(ans,arr[mid]);
                high=mid-1;
            }
        }
        return ans;
    }
}

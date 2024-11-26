class Solution {
    public boolean search(int[] arr, int target) {
        int l=0,r=arr.length-1,mid=0;
        while(l<r && arr[r]==arr[l]) r--;
        while(l<=r)
        {
            mid=(l+r)/2;
            if(arr[mid]==target) return true;
            if(arr[l]<=arr[mid])//left sorted
            {
                if(arr[l]<=target && target<arr[mid])
                r=mid-1;
                else
                l=mid+1;
            }
            else//right sorted
            {
                if(arr[mid]<target && target<=arr[r])
                l=mid+1;
                else
                r=mid-1;
            }
        }
        return false;
    }
    
}

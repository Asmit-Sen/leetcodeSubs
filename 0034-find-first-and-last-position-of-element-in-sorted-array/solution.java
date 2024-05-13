class Solution {
    int first(int arr[], int target)
    {
        int low=0,high=arr.length-1,mid,ans=-1;
        while(low<=high)
        {
            mid=low+(high-low)/2;
            if(arr[mid]==target) {ans=mid;high=mid-1;}
            else if(arr[mid]>target) high=mid-1;
            else low=mid+1; 
        }
        return ans;
    }

    int last(int arr[], int target)
    {
        int low=0,high=arr.length-1,mid,ans=-1;
        while(low<=high)
        {
            mid=low+(high-low)/2;
            if(arr[mid]==target) {ans=mid;low=mid+1;}
            else if(arr[mid]<target) low=mid+1;
            else high=mid-1;
        }
        return ans;
    }

    public int[] searchRange(int[] arr, int target) {
        int first=first(arr,target);
        int last=last(arr,target);
        return new int[] {first,last};
    }
}

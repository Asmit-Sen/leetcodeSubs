class Solution {
    int countpairs(int arr[], int low, int mid, int high)
    {
        int right=mid+1,c=0;
        for(int left=low;left<=mid;left++)
        {
            while(right<=high && (double)arr[left]/2>arr[right]) 
                right++;
            c+=right-(mid+1);
        }
        return c;
    }
    int merge(int arr[], int low, int high)
    {
        int mid=low+(high-low)/2;
        int c=0;
        if(low>=high) return 0;
        c+=merge(arr,low,mid);
        c+=merge(arr,mid+1,high);
        c+=countpairs(arr, low,mid,high);
        mergesort(arr,low, mid, high);
        return c;
    }
    void mergesort(int arr[], int low, int mid, int high)
    {
        List <Integer> list=new ArrayList<>();
        int left=low,right=mid+1;
        int c=0;
       
        while(left<=mid && right<=high)
        {
            if(arr[left]<=arr[right])
            list.add(arr[left++]);
            else
            list.add(arr[right++]);
        }
        
        while(left<=mid)
        list.add(arr[left++]);
        
        while(right<=high)
        list.add(arr[right++]);
        
        for(int i=low;i<=high;i++)
        {
            arr[i]=list.get(i-low);
        }
        
    }
    public int reversePairs(int[] arr) {

        int pairs= merge(arr,0,arr.length-1);
        return pairs;
        
    }
}

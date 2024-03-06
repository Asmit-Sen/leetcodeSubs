class Solution {
    void swap(int arr[], int i, int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public void sortColors(int[] arr) {
        int low=0,mid=0,high=arr.length-1;
        while (mid<=high)
        {
            if(arr[mid]==0)
            {
                swap(arr,mid,low);
                mid++; low++;
            }
            else if(arr[mid]==1)
            mid++;
            else if(arr[mid]==2)
            {
                swap(arr,mid,high);
                high--;
            }
        }
        for (int it:arr)
        System.out.println(it+" ");
        
    }
}

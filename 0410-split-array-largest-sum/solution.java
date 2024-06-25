class Solution {
    int parts (int arr[], int k, int max)
    {
        int cnt=0,sum=0;
        for(int i=0;i<arr.length;i++)
        {
            if((sum+arr[i])<=max) sum+=arr[i];
            else 
            {
                sum=arr[i];
                cnt++;
            }
        }
        return cnt+1;
    }
    public int splitArray(int[] arr, int k) {
        int sum=0,max=-1;
        for(int nums:arr)
        {
            sum+=nums;
            max=(int)Math.max(nums,max);
        }

        int low=max,high=sum,mid,res=-1;
        while(low<=high)
        {
            mid=low+(high-low)/2;
            int parts=parts(arr,k,mid);
            System.out.println("mid : "+mid + " parts : "+parts);
            if(parts<=k) high=mid-1;
            else low=mid+1;
        }
        return low;       
    }
}

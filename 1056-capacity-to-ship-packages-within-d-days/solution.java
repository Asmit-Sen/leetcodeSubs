class Solution {

    int days (int arr[], int n, int maxdays, int cap)
    {
        int sum=0,days=1;
        for(int i=0;i<n;i++)
        {
            if(sum+arr[i]<=cap)
            sum+=arr[i];
            else
            {
                sum=arr[i];
                days++;
            }
        }
        if(days<=maxdays) return 1;
        else return 0;

    }
    public int shipWithinDays(int[] arr, int days) {
        Solution ob=new Solution();
        int max=-1,sum=0;
        for(int num:arr)
        {
            sum+=num;
            max=(int)Math.max(max,num);
        }

        int low=max,high=sum,mid;
        while(low<=high)
        {
            mid=low+(high-low)/2;
            if(ob.days(arr,arr.length,days,mid)==0) low=mid+1;
            else high=mid-1;
        }
        return low;
    }
}

class Solution {
    int hours( int arr[], int h, int allowed)
    {
        int cnt=0;
        for(int num:arr)
            {
                cnt+=(int)Math.ceil((double)num/(double)allowed);// type casting wjile div
                if(cnt>h) return 0; // rate too slow
            }
        return 1; // rate too fast, can be slowed
    }
    public int minEatingSpeed(int[] arr, int h) {
        int low=1,high=-1;
        Solution ob=new Solution();
        for(int num:arr)
            high=(int)Math.max(high,num);
        int ans=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(ob.hours(arr,h,mid)==0) low=mid+1;
            else high=mid-1;
        }
        return low;
    }
}

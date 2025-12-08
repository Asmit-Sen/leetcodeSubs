class Solution {
    boolean find(int nums[], int p, int diff){
        //can i find atleast p groups with differnce <= diff
        int c=0, n=nums.length;
        for(int i=0;i+1<n;i++){
            if (nums[i+1]-nums[i]<=diff) {
                c++;
                i++;
            }
        }
        return (c>=p);
    }
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;
        int low = 0, high = nums[n-1]-nums[0];

        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(find(nums,p,mid)){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }

        return ans;
    }
}

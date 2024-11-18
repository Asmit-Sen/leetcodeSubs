class Solution {
    public int countValidSelections(int[] nums) {
        int n=nums.length;
        int pre[]=new int[n];
        int suff[]=new int[n];

        int cnt=0;
        int presum=0,suffsum=0;
        for(int i=0;i<n;i++)
        {
            pre[i]=presum;
            suff[n-1-i]=suffsum;

            presum+=nums[i];
            suffsum+=nums[n-1-i];
        }

        for(int i=0;i<n;i++)
            {
                if(nums[i]==0)
                    if(pre[i]==suff[i])
                        cnt+=2;
                    else if((int)Math.abs(pre[i]-suff[i])==1)
                        cnt++;
                    
            }
        System.out.print(Arrays.toString(pre));
        System.out.print(Arrays.toString(suff));
        return cnt;
    }
}

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length, ans=0, pos=0, maxi=0;
        Arrays.sort(nums);
        int lis[]=new int[n];
        Arrays.fill(lis,1);

        int pre[]=new int[n];
        Arrays.fill(pre,-1);

        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(nums[i]%nums[prev]==0 && lis[prev]+1>lis[i]){
                    lis[i]=lis[prev]+1;
                    pre[i]=prev;
                }
            }
            if(lis[i]>maxi){
                maxi=lis[i];
                pos=i;
            }
        }

        List<Integer> list= new ArrayList<>();
        while(pos!=-1){
            list.add(nums[pos]);
            pos=pre[pos];
        }
        return list;
        

    }
}

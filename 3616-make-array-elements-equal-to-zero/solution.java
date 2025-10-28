class Solution {
    public int countValidSelections(int[] nums) {
        //find no if indices where prefix sum == postfix sum && the cur ele is 0
        int n = nums.length;
        int prefix[]= new int[n];
        int postfix[]= new int[n];
        
        prefix[0]=0;
        for(int i=1;i<n;i++){
            prefix[i] = nums[i-1] + prefix[i-1];
        }
        
        postfix[0]=0;
        for(int i=n-2;i>=0;i--){
            postfix[i] = nums[i+1] + postfix[i+1];
        }

        int ans=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0) {
                if(prefix[i]==postfix[i]) ans+=2;
                else if ((int)Math.abs(prefix[i]-postfix[i])==1) ans++;
            } 
        }
        return ans;

    }
}

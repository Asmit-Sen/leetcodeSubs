class Solution {
    public int[] countOppositeParity(int[] nums) {
        int n =nums.length;
        int ans[]=new int[n];

        int even = 0, odd = 0;
        for(int i=n-1;i>=0;i--){
            if ((nums[i]&1)==0) ans[i]=odd;
            else ans[i]=even;
            
            if ((nums[i]&1)==1) odd++;
            else even++;
        }

        return ans;
    }
}

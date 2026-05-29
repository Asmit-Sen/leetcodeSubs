class Solution {
    int sum(int n){
        int ans = 0;
        while(n>0){
            ans += n%10;
            n/=10;
        }
        return ans;
    }
    public int minElement(int[] nums) {
        int mini = (int)1e6;
        for(int x:nums) mini = Math.min(mini,sum(x));
        return mini;
    }
}

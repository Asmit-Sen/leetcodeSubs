class Solution {
    public int sumOfGoodIntegers(int n, int k) {
        int l = Math.max(1, n-k);
        int h =  n + k;

        int ans =0;
        for(int i=l;i<=h;i++){
            if ((n & i) ==0) ans += i;
        }

        return ans;
    }
}

class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int f = 1, ans = 0;
        while(n>0){
            ans += f * Math.min(8,n);
            n-=8;
            f++;
        }
        return ans;
    }
}

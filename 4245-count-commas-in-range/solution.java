class Solution {
    int f (int n){
        int c=0;
        while(n!=0){
            n/=10;
            c++;
        }
        return c;
    }
    public int countCommas(int n) {
        int ans=0;
        for(int i=1;i<=n;i++)
            ans += f(i)<4 ? 0 : (int)Math.ceil((float)f(i)/3)-1;

        return ans;
    }
}

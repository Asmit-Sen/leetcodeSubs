class Solution {
    public int concatenatedBinary(int n) {
        long ans=0, bits=0, mod=(long)1e9+7;
        for(int i=1;i<=n;i++){
            if ((i&(i-1))==0){
                bits++;
            }
            ans = ((ans << bits) % mod + i) % mod;
        }
        return (int)ans;
    }
}

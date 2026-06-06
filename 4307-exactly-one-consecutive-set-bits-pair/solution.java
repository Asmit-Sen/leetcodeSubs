class Solution {
    public boolean consecutiveSetBits(int n) {
        // 10100011000
        // 11

        int mask = 3;
        int c=0;
        while(mask<=n){
            if ((mask & n) == mask) c++;
            mask = mask<<1;
        }
        return c==1;
    }
}

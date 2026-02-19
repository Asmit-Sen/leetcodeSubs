class Solution {
    public boolean hasAlternatingBits(int n) {
        //    101010101
        //  ^ 010101010
        //    111111111
        //  +         1
        //   1000000000
        //  &0111111111
        //  =         0

        int x = n  ^ (n>>1);
        return ((x&(x+1))==0);
    }
}

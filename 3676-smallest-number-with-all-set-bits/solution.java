class Solution {
    public int smallestNumber(int n) {
        int ans=n;
        // set all the bits
        return (1<< ((int)(Math.log(n)/Math.log(2)) + 1)) -1;
    }
}

class Solution {
    public int countOdds(int low, int high) {
        // odd odd len/2+1
        // even even len/2
        // odd even len/2+1
        // even odd len/2+1

        if ((low&1)==0 && (high&1)==0) 
        return (high-low)/2;
        
        return ((high-low)/2)+1;
    }
}

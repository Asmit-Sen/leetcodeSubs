class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long sum=0, maxi=0, mini= 0;
        for(int x: differences){
            sum+=x;
            mini=(int)Math.min(mini,sum);
            maxi=(int)Math.max(maxi,sum);
        }
        return (int)Math.max(0,(upper-maxi)-(lower-mini)+1);
    }
}

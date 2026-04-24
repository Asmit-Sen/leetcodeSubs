class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int ans=0,l=0,r=0,d=0;
        for(char c:moves.toCharArray()){
            if (c=='L') l++;
            else if (c=='R') r++;
            else d++;
        }
        if (l>=r){
            return l + d - r;
        }
        return r + d - l;
    }
}

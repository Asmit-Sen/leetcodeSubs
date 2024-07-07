class Solution {
    public int numWaterBottles(int num, int c) {
        int cnt=0;
        int full=num,empty=0;
        
        cnt+=full;
        empty=full;    

        while(empty>=c)
        {
            full=empty/c;// exchange
            empty=empty%c;// reduced empty
            cnt+=full;// drink
            empty+=full;//new empty
        }
        return cnt;

    }
}

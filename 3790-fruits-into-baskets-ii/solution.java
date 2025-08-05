class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int cnt=0;
        for(int fruit:fruits){
            for(int i=0;i<baskets.length;i++){
                if(fruit<=baskets[i]){
                    cnt++;
                    baskets[i]=0;
                    break;
                }
            }
        }
        return fruits.length-cnt;
    }
}

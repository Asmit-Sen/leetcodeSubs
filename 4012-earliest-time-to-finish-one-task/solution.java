class Solution {
    public int earliestTime(int[][] tasks) {
        int mini=(int)1e9;
        for(int task[]: tasks) mini=(int)Math.min(mini,task[0]+task[1]);
        return mini;
    }
}

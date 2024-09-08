class Solution {
    public boolean canJump(int[] arr) {
        int maxInd=0;
        for(int i=0;i<arr.length;i++)
        {
            if(i<=maxInd)
            maxInd=(int)Math.max(maxInd,i+arr[i]);
            else return false;
        }
        return true;
    }
}

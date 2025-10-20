class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x=0;
        for(String op : operations){
            if(op.charAt(0)=='+' || op.charAt(2)=='+') x++;
            else x--;
        }
        return x;
    }
}

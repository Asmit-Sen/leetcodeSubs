class Solution {
    public boolean checkOnesSegment(String s) {
        int prev=-1;
        prev = s.charAt(0)=='1'?0:-1;

        for(int i=1;i<s.length();i++){
            if (s.charAt(i)=='1'){
                if (prev==-1){
                    prev=i;
                    continue;
                }
                else{
                    if(i==prev+1) {
                        prev=i;
                        continue;
                    }
                    return false;
                }
            }
        }
        return true;
    }
}

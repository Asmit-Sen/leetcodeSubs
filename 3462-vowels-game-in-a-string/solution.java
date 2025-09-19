class Solution {
    public boolean doesAliceWin(String s) {
        int c=0;
        for(char x: s.toCharArray()){
            if(x=='a' || x=='e' || x=='i' || x=='o' || x=='u') c++;
        }
        if(c==0) return false;
        return true;
    }
}

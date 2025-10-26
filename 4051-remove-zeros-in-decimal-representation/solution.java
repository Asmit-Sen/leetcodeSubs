class Solution {
    public long removeZeros(long n) {
        long ans=0;
        char num[] = String.valueOf(n).toCharArray();
        for(char d : num){
            if((d-'0')!=0) ans=ans*10+(d-'0');
        }
        return ans;
    }
}

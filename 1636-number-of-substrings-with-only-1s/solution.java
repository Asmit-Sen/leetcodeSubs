class Solution {
    public int numSub(String s) {

        int prev=-1, mod=(int)1e9+7;
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0') prev=-1;
            else{
                if (prev==-1) prev=i;
                ans=(ans+(i-prev+1))%mod;
            }
        }   
        return ans;
    }
}

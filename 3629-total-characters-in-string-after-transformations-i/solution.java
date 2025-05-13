class Solution {
    public int lengthAfterTransformations(String s, int t) {
        long freq[]= new long[26];
        for(char ch:s.toCharArray())
        freq[ch-'a']++;
        //count freq of all chars in s

        long sum=0, mod=(long)1e9+7;
        for(int i=0;i<t;i++){
            long temp[]=new long[26];
            for(int j=0;j<26;j++){
                if(j==25){
                    temp[0]=(temp[0]+freq[25])%mod;
                    temp[1]=(temp[1]+freq[25])%mod;
                }
                else
                temp[j+1]=(temp[j+1]+freq[j])%mod;
            }
            // freq=temp.clone();
            freq=temp;
        }

        for(long f:freq)
        sum=(sum+f)%mod;

        return (int)(sum%mod);
    }
}

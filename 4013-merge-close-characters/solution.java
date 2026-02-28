class Solution {
    public String mergeCharacters(String s, int k) {
        int f[]=new int[26];
        Arrays.fill(f,-1);
        
        int n=s.length();
        
        StringBuilder str = new StringBuilder(s);
        for(int i=0;i<n;i++){
            char c=str.charAt(i);
            if(f[c-'a']==-1) f[c-'a']=i;
            else{
                if (i-f[c-'a']<=k){
                    str.deleteCharAt(i);
                    i--;
                    n--;
                }
                else
                    f[c-'a']=i;
            }
        }

        return str.toString();
    }
}

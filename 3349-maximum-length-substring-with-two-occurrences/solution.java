class Solution {
    public int maximumLengthSubstring(String s) {
        int f[] = new int[26];
        int l=0, r=0, ans=0;
        while(r<s.length()){
            f[s.charAt(r)-'a']++;
            while(f[s.charAt(r)-'a']==3){
                f[s.charAt(l)-'a']--;
                l++;
            }

            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}

class Solution {
    public int numberOfSpecialChars(String word) {
        int last[]=new int[26];
        Arrays.fill(last,-1);

        int caps[]=new int[26];
        Arrays.fill(caps,-1);

        int n = word.length();

        for(int i=0; i<n; i++){
            char c = word.charAt(i);
            if (c>=65 && c<=90) {
                if (caps[c-'A']==-1) caps[c-'A']=i; 
            }
            else last[c-'a']=i;
        }

        int ans = 0;
        for(int i=0; i<26; i++){
            if (caps[i]!=-1 && last[i]!=-1 && last[i]<caps[i]) ans++;
        }
        return ans;
    }
}

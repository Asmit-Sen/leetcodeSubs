class Solution {
    public int maxNumberOfBalloons(String text) {
        int f[]=new int[26];
        for(char c : text.toCharArray()){
            f[c-'a']++;
        }

        String target="balloon";
        int ans = (int)1e6;
        for (char c : target.toCharArray()){
            if (c=='l' || c=='o')
                ans = Math.min(ans, f[c-'a']/2);
            else 
                ans = Math.min(ans, f[c-'a']);
        }
        return ans;
    }
}

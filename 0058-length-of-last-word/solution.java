class Solution {
    public int lengthOfLastWord(String s) {
        s.trim();
        int c=0;
        for (int i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)==' '&& c!=0) return c;
            else if(s.charAt(i)==' ') c=0;
            else c++;
        }
        return c;
    }
}

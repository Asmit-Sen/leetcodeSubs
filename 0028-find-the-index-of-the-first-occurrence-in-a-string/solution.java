class Solution {
    public int strStr(String haystack, String needle) {
        String sub="";
        for (int i=0;i<=haystack.length()-needle.length();i++)
        {
            sub=haystack.substring(i,i+needle.length());
            if(sub.equals(needle)) return i;
            
        }
        return -1;
    }
}

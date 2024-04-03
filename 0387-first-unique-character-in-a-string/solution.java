class Solution {
    public int firstUniqChar(String s) {
        int hash[]=new int[26];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++)
        {
            hash[s.charAt(i)-97]++;
        }
        for(int i=0;i<26;i++)
        if(hash[i]==1) min=(int)Math.min(s.indexOf((char)i+97),min);
        if(min==Integer.MAX_VALUE) return -1;
        return min;
        
    }
}

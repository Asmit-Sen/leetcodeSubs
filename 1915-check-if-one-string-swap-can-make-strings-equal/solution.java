class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
    int hash1[]=new int[26];
    int hash2[]=new int[26];
    int cnt=0;

    for(int i=0;i<s1.length();i++){
        if(s1.charAt(i)!=s2.charAt(i))
            cnt++;
        hash1[s1.charAt(i)-'a']++;
        hash2[s2.charAt(i)-'a']++;
    }

    for(int j=0;j<26;j++)
    if(hash1[j]!=hash2[j])
        return false;

    return cnt<=2;

    }
}

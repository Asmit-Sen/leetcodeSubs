class Solution {
    public String getEncryptedString(String str, int k) {
        String ns="";
        for(int i=0;i<str.length();i++)
            ns+=str.charAt((i+k)%str.length());
        return ns;
    }
}

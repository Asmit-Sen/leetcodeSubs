class Solution {
    public String makeFancyString(String s) {
        if(s.length()<3) return s;
        StringBuilder str= new StringBuilder();
        for(int i=1;i<s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i-1) && s.charAt(i)==s.charAt(i+1)) continue;
            str.append(s.charAt(i));
        }
        str.insert(0,s.charAt(0));
        str.append(s.charAt(s.length()-1));
        return str.toString();
    }
}

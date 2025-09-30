class Solution {
    boolean isVowel (char c){
        return (c=='a' || c=='e' || c=='i' || c=='i' || c=='o' 
        || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U' );
    }
    public String sortVowels(String s) {
        List<Character> list = new ArrayList<>();
        for(char c: s.toCharArray()){
            if(isVowel(c)) list.add(c);
        }
        Collections.sort(list);
        StringBuilder sb=new StringBuilder();
        int p=0;
        for (char c: s.toCharArray()){
            if(isVowel(c)) sb.append(list.get(p++));
            else sb.append(c);
        }
        return sb.toString();
    }
}

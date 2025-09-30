class Solution {
    public int canBeTypedWords(String s, String brokenLetters) {
        String str[]=s.split(" ");
        List<String> words= new ArrayList(Arrays.asList(str));

        int c=words.size();
        for(String word : words){
            for(int i=0;i<brokenLetters.length();i++){
                if (word.indexOf(brokenLetters.charAt(i))!=-1){
                    c--;
                    break;
                }
            }
        }
        return c;

    }
}

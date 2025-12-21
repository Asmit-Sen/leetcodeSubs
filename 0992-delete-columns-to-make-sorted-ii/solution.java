class Solution {
    public int minDeletionSize(String[] strs) {
        int ans=0;

        int numberOfWords= strs.length, columns = strs[0].length();
        boolean isLexicalOrder = true, checkNext = false;
        boolean[] isSafeTillNow = new boolean[numberOfWords];

        //for every column
        for(int i=0;i<columns;i++){
            //go across every word and check is all the chars at the ith column
            // are in lex order or not

            isLexicalOrder = true;

            for(int j=0;j<numberOfWords-1;j++){
                if (!isSafeTillNow[j] && strs[j].charAt(i)>strs[j+1].charAt(i)){
                    ans++;
                    isLexicalOrder = false;
                    break;
                }
            }

            if (isLexicalOrder){
                //its fine upto now
                for(int j=0;j<numberOfWords-1;j++){
                    if(strs[j].charAt(i) < strs[j+1].charAt(i))
                        isSafeTillNow[j]=true;
                }
            }

        } 
        return ans;
    }
}

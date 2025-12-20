class Solution {
    public int minDeletionSize(String[] strs) {

        int columns = strs[0].length();
        int words = strs.length;
        int ans=0;
        for(int i=0;i<columns;i++){
            for(int j=1;j<words;j++){
                if (strs[j].charAt(i)-strs[j-1].charAt(i)<0){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}

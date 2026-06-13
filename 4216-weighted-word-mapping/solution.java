class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String ans = "";
        int sum = 0;

        for (String word : words){
            sum = 0;
            for (char c: word.toCharArray()){
                sum = (sum + weights[c-'a']) % 26;
            }
            ans += (char)('a' + 25 - sum);
        }

        return ans;
    }
}

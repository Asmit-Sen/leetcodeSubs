class Solution {
    public int numberOfSpecialChars(String word) {
        int s=0, l=0;
        for(char c : word.toCharArray()){
            if (c>=97) s |= (1 << (c-'a'));
            else l |= (1 << (c-'A'));
        }
        return Integer.bitCount(s&l);
    }
}

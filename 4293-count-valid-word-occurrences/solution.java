import java.util.*;

class Solution {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        // 1. Build the full string
        StringBuilder sb = new StringBuilder();
        for (String chunk : chunks) sb.append(chunk);
        String s = sb.toString();
        int n = s.length();

        // 2. Extract valid words
        Map<String, Integer> wordCounts = new HashMap<>();
        StringBuilder currentWord = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) {
                currentWord.append(c);
            } else if (c == '-') {
                // Check if hyphen is valid (surrounded by letters)
                if (i > 0 && i < n - 1 && 
                    Character.isLowerCase(s.charAt(i-1)) && 
                    Character.isLowerCase(s.charAt(i+1))) {
                    currentWord.append(c);
                } else {
                    processWord(currentWord, wordCounts);
                }
            } else {
                processWord(currentWord, wordCounts);
            }
        }
        processWord(currentWord, wordCounts); // Final check

        // 3. Map queries to counts
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = wordCounts.getOrDefault(queries[i], 0);
        }
        return ans;
    }

    private void processWord(StringBuilder sb, Map<String, Integer> counts) {
        if (sb.length() > 0) {
            String word = sb.toString();
            counts.put(word, counts.getOrDefault(word, 0) + 1);
            sb.setLength(0); // Clear for next word
        }
    }
}


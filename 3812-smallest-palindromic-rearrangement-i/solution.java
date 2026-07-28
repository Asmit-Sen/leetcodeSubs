class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int[] freq = new int[26];
        
        // Step 1: Count character frequencies from the first half of the palindrome
        for (int i = 0; i < n / 2; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        
        // Step 2: Build the lexicographically smallest sorted left half
        StringBuilder leftHalf = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                leftHalf.append((char) ('a' + i));
                freq[i]--;
            }
        }
        
        // Step 3: Construct the final palindrome using StringBuilder
        StringBuilder ans = new StringBuilder();
        ans.append(leftHalf); // Add sorted left half
        
        if (n % 2 == 1) { // If odd length, append the middle character
            ans.append(s.charAt(n / 2));
        }
        
        // Append the reverse of the left half to complete the palindrome
        ans.append(new StringBuilder(leftHalf).reverse());
        
        return ans.toString();
    }
}


class Solution {
    boolean valid(Set<Integer> set, Map<Integer, Integer> freq){
        boolean valid = true;
        int val=0;
        
        for(int key : freq.keySet()){
            // max f among the max ele in this window
            if (set.contains(key)) val = Math.max(val, freq.get(key));
        }
        if (val%2==1) return false;
        for(int key : freq.keySet()){
            if (set.contains(key) && freq.get(key)!=val) return false;
            if (!set.contains(key) && freq.get(key)!=val/2) return false;
        }
        return true;
    }
    public int getLength(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        
        int maxLen = 1; // Any single element subarray is balanced by default

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> freqMap = new HashMap<>();
            Map<Integer, Integer> freqOfFreq = new HashMap<>();
            
            int maxFreq = 0;
            
            // Expand the window dynamically to the right
            for (int j = i; j < n; j++) {
                int val = nums[j];
                
                int oldFreq = freqMap.getOrDefault(val, 0);
                int newFreq = oldFreq + 1;
                freqMap.put(val, newFreq);
                
                // Track max frequency dynamically
                if (newFreq > maxFreq) {
                    maxFreq = newFreq;
                }
                
                // Update frequency-of-frequencies map
                if (oldFreq > 0) {
                    int count = freqOfFreq.get(oldFreq);
                    if (count == 1) {
                        freqOfFreq.remove(oldFreq);
                    } else {
                        freqOfFreq.put(oldFreq, count - 1);
                    }
                }
                freqOfFreq.put(newFreq, freqOfFreq.getOrDefault(newFreq, 0) + 1);
                
                // Check if current subarray state is balanced in O(1) time
                boolean isBalanced = false;
                int distinctFreqsCount = freqOfFreq.size();
                
                if (distinctFreqsCount == 1) {
                    // Valid only if all elements are identical (size == 1)
                    if (freqMap.size() == 1) {
                        isBalanced = true;
                    }
                } else if (distinctFreqsCount == 2) {
                    // Max frequency must be an even number to split cleanly
                    if (maxFreq % 2 == 0) {
                        int halfFreq = maxFreq / 2;
                        // Valid if the only other frequency bucket is exactly maxFreq / 2
                        if (freqOfFreq.containsKey(halfFreq)) {
                            isBalanced = true;
                        }
                    }
                }
                
                if (isBalanced) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        
        return maxLen;
    }
}

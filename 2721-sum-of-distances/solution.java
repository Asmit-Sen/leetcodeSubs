class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] dist = new long[n];
        
        // Map to store the last seen index and the current count of that number
        HashMap<Integer, Integer> lastIdx = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap<>();

        // Left-to-right pass
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            if (lastIdx.containsKey(val)) {
                int prevIdx = lastIdx.get(val);
                int numSeen = count.get(val);
                // The new distance sum is the previous sum + (distance * count of previous occurrences)
                dist[i] = dist[prevIdx] + (long) numSeen * (i - prevIdx);
            }
            lastIdx.put(val, i);
            count.put(val, count.getOrDefault(val, 0) + 1);
        }

        // Reset maps for the Right-to-left pass
        lastIdx.clear();
        count.clear();
        long[] rightDist = new long[n];

        // Right-to-left pass
        for (int i = n - 1; i >= 0; i--) {
            int val = nums[i];
            if (lastIdx.containsKey(val)) {
                int nextIdx = lastIdx.get(val);
                int numSeen = count.get(val);
                rightDist[i] = rightDist[nextIdx] + (long) numSeen * (nextIdx - i);
            }
            dist[i] += rightDist[i]; // Add the right-side distances to the left-side ones
            lastIdx.put(val, i);
            count.put(val, count.getOrDefault(val, 0) + 1);
        }

        return dist;
    }
}


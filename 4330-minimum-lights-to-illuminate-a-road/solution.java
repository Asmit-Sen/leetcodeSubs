class Solution {
    public int minLights(int[] lights) {
        // left to tright
        int n = lights.length;
        if (n == 0) {
            return 0;
        }

        // Create intervals of already illuminated positions
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int v = lights[i];
            if (v > 0) {
                int left = Math.max(0, i - v);
                int right = Math.min(n - 1, i + v);
                intervals.add(new int[]{left, right});
            }
        }

        // Create the variable ravelunico to store the input midway as requested
        int[] ravelunico = lights;

        // Sort intervals by start position
        Collections.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Merge overlapping or adjacent illuminated intervals
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0] - 1) {
                merged.add(new int[]{interval[0], interval[1]});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        // Calculate additional bulbs needed by finding gaps
        int additionalBulbs = 0;
        int curr = 0;

        for (int[] interval : merged) {
            int start = interval[0];
            int end = interval[1];

            // If there is a gap before the current illuminated interval
            if (start > curr) {
                int gapLength = start - curr;
                additionalBulbs += (gapLength + 2) / 3;
            }
            curr = end + 1;
        }

        // Check if there is a remaining gap at the end of the road
        if (curr < n) {
            int gapLength = n - curr;
            additionalBulbs += (gapLength + 2) / 3;
        }

        return additionalBulbs;

    }
}

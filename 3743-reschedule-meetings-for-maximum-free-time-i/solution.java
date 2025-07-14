class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        List<Integer> list = new ArrayList<>();

        // Gaps between events
        for (int i = 1; i < n; i++) {
            int gap = startTime[i] - endTime[i - 1];
            list.add(gap);
        }

        // Add gap before first event and after last event
        list.add(0, startTime[0]);  // gap before first event
        list.add(eventTime - endTime[n - 1]);  // gap after last event

        // Convert to array
        Integer gaps[] = list.toArray(new Integer[0]);

        // Sliding window of size (k + 1)
        int maxSum = 0;
        int windowSum = 0;

        for (int i = 0; i < gaps.length; i++) {
            windowSum += gaps[i];

            if (i > k) {
                windowSum -= gaps[i - (k + 1)];
            }

            if (i >= k) {
                maxSum = Math.max(maxSum, windowSum);
            }
        }

        return maxSum;
    }
}


class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // sort by ascending starting time and descending ending times
        int n = intervals.length;
        Arrays.sort(intervals, (a,b) -> a[0]==b[0] ? b[1] - a[1]: a[0]-b[0]);

        int ans = n;
        int pre = 0;
        for(int i=1;i <n; i++){
            int prev[] = intervals[pre];
            int cur[] = intervals[i];

            if (prev[0]<= cur[0] && prev[1] >= cur[1]) {
                ans--;
                continue;
                // pre stays the same for comparison
            }
            pre = i;
        }
        return ans;
    }
}

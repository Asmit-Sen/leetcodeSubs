class Solution {
    // Return long to prevent overflow during intermediate calculations
    long sum(long n) {
        return n * (n + 1) / 2;
    }

    int findWork(int time, long allowed, int height) {
        int low = 0, high = height;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (1L * time * sum(mid) <= allowed) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    boolean check(long allowed, int mountainHeight, int[] workerTimes) {
        long total = 0; 
        for (int i = 0; i < workerTimes.length; i++) {
            total += findWork(workerTimes[i], allowed, mountainHeight);
            if (total >= mountainHeight) return true;
        }
        return total >= mountainHeight;
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int maxi = 0;
        for (int x : workerTimes) maxi = Math.max(maxi, x);

        long high = (long) maxi * sum(mountainHeight);
        long low = 0;
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (check(mid, mountainHeight, workerTimes)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}


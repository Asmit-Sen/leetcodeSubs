class Solution {
    public long minEnergy(int n, int brightness, int[][] intervals) {
        long bulbs = (long)(Math.ceil(brightness/3.0));
        
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);

        List<int[]> times = new ArrayList<>();
        times.add(new int[]{intervals[0][0], intervals[0][1]});

        int l = intervals.length;
        for(int i=1;i<l;i++){
            int prev[] = times.get(times.size()-1);
            int start = prev[0];
            int end = prev[1];
            
            if (intervals[i][0] <= end){
                // merge these two
                times.remove(times.size()-1);
                times.add(new int[]{start , Math.max(end, intervals[i][1]) });
            }
            else 
                times.add(new int[]{intervals[i][0], intervals[i][1]});
        }
        
        long totaltime = 0;
        for(int range[] : times){
            System.out.println(range[0]+","+range[1]);
            totaltime += range[1] - range[0] + 1;
        }
        System.out.println(bulbs);
        System.out.println(totaltime);
        return totaltime * bulbs;
    }
}

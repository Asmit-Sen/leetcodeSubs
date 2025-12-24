class Solution {
    int foo(int events[][], int target){
        int low = 0, high = events.length-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(events[mid][0]>target){
                high=mid-1;
            }
            else low=mid+1;
        }
        return low;
    }
    public int maxTwoEvents(int[][] events) {

        int n=events.length;

        //sort as per start times
        Arrays.sort(events, (a,b) -> (a[0]-b[0]));

        //maxValueAfterCurrentEvent <event, largestValue)
        int maxValueAfterCurrentEvent[] = new int[n];
        maxValueAfterCurrentEvent [n-1] = events [n-1][2]; 
        for(int i=n-2;i>=0;i--){
            int currentValue = events[i][2];
            int startTime = events[i][0];
            maxValueAfterCurrentEvent[i] = (int)Math.max(maxValueAfterCurrentEvent[i+1], currentValue);
        } 

        int ans=0;
        for(int event[] : events){
            int endTime = event[1];
            int value = event[2];
            //gives index of the first event that start after the current events endtime
            int next = foo(events, endTime);
            if (next==n) {
                ans=(int)Math.max(ans, value);
                continue;
            }
            //calculate the max value possible for the current event 
            //and eny event after this
            int maxPossibleValue = maxValueAfterCurrentEvent[next];
            ans = (int)Math.max(ans, value + maxPossibleValue);
        }
        return ans;
    }
}

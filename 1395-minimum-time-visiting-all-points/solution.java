class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int n=points.length;
        int ans=0;
        
        for(int i=1;i<n;i++){
            
            int x=points[i][0];
            int y=points[i][1];

            int x0=points[i-1][0];
            int y0=points[i-1][1];

            int dx=(int)Math.abs(x-x0);
            int dy=(int)Math.abs(y-y0);
            
            ans += (int)Math.max(dx, dy);
        }

        return ans;
    }
}

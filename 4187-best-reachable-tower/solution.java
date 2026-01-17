class Solution {
    public int[] bestTower(int[][] towers, int[] center, int radius) {
        Arrays.sort(towers, (a,b)-> a[0]!=b[0] ? b[0] - a[0] : b[1] - a[1] );
        int maxi = (int)Integer.MIN_VALUE;
        int cx = center[0], cy = center[1];

        int ans[]=new int[2];
        Arrays.fill(ans,-1);
        
        int quality=0;
        for(int tower[] : towers){
            int x=tower[0], y=tower[1];

            int d = (int)Math.abs(cx-x) + (int)Math.abs(cy-y);
            if(d<=radius && tower[2]>=quality){
                ans[0] = x;
                ans[1] = y;
                quality = tower[2];
            }
        }

        return ans;
        
    }
}

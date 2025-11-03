class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int sum=0;
        for(int t: neededTime) sum+=t;
 
        int prev=-1;
        int maxi=neededTime[0];
        
        for(int i=1;i<n;i++){
            if(colors.charAt(i)!=colors.charAt(i-1))
            {
                sum-=maxi;
                maxi=neededTime[i];
            }
            else
            maxi = (int)Math.max(maxi, neededTime[i]);
        }

        return sum - maxi;
    }
}

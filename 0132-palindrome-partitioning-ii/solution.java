class Solution {
    boolean palin (String s, int i, int j){
        while(i<j){
            if (s.charAt(i)!=s.charAt(j))
            return false;
            i++;
            j--;
        }
        return true;
    }
    public int minCut(String s) {
        int n = s.length();
        int dp[] = new int[n+1];

        Arrays.fill(dp, (int)1e6);
        dp[n] = 0;
        
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if (palin(s,i,j)) 
                    dp[i] = Math.min(dp[i], 1 + dp[j+1]);
            }
        }
        return dp[0]-1;
    }
}

class Solution {
    boolean f(int i, int min, int max, String s, int dp[]){
        if (i>=s.length() || s.charAt(i)=='1') return false;
        if (i==s.length() - 1) return s.charAt(i) == '0';

        if (dp[i]!=-1) return dp[i]==1?true:false;

        boolean ans = false;
        for(int j=min; j<=max; j++){
            ans |= f(i+j, min, max, s, dp);
        }
        dp[i] = ans == true ? 1 : 0;
        return ans;
    }
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean dp[] = new boolean[n];
        Arrays.fill(dp, false);

        dp[0]=true;
        for(int i=1;i<n;i++){
            if (s.charAt(i)=='1') continue;
            for(int j=minJump; j<=maxJump; j++){
                if (i-j >= 0 && dp[i-j]) {
                    dp[i]=true; 
                    break;
                }
            }
        }

        // return f(0,minJump, maxJump, s, dp);
        return dp[n-1];
    }
}

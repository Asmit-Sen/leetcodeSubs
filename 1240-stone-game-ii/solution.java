class Solution {
    Integer f(int l, int m, int suff[], Integer dp[][]){
        if (l>=suff.length-1) return 0;
        if (l==suff.length-2) return dp[l][m] = suff[l];

        if(dp[l][m]!=null) return dp[l][m];

        int score = Integer.MIN_VALUE;
        for(int i=1;i<=2*m;i++){
            if (l+i < suff.length)
            score = Math.max(score, suff[l] - suff[l+i] - f(l+i, Math.max(i,m), suff, dp));
        }
        return dp[l][m] = score;
    }
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int suff[]=new int[n+1];
        suff[n]=0;

        //  1 2 3 4 
        // 10 9 7 4 0
        // sum(l,r) = suff[l]-suff[r+1]

        for(int i=n-1;i>=0;i--) suff[i] = piles[i] + suff[i+1];

        // for(int x:suff) System.out.print(x+",");
        // System.out.println();

        Integer dp[][]= new Integer[n][n+1];
        int diff = f(0, 1, suff, dp);
        System.out.println(diff); 
        return (diff + suff[0])/2;
    }
}

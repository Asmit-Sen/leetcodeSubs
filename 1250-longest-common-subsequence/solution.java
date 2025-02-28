class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int m=s1.length(),n= s2.length();
        int[] prev=new int[n+1], cur=new int[n+1];
        
        //shift indices from (0...m-1) by +1 to account for index=-1 as (0....m)
        
        //base cases for -ve indices

        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1)) cur[j] = 1+prev[j-1];
                else cur[j]=(int)Math.max(cur[j-1],prev[j]);
            }
            prev=cur.clone();
        }
        return prev[n];
    }
}

class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int ans=0,maxi=0;
        for(int row[]:dimensions){
            int a= row[0];
            int b= row[1];
            if((a*a+b*b)>maxi){
                maxi=a*a+b*b;
                ans=a*b;
            }
            else if((a*a+b*b)==maxi){
                ans=(int)Math.max(ans, a*b);            }
        }
        return ans;
    }
}

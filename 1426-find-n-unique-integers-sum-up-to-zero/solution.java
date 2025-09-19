class Solution {
    public int[] sumZero(int n) {
        int ans[]=new int[n];
        int p=0;
        if((n&1)==1){
            //odd
            for(int i=0;i<n/2;i++)
            {
                ans[p++]=i+1;
                ans[p++]=-(i+1);
            }
            ans[p++]=0;
            return ans;
        }
        else{
            for(int i=0;i<n/2;i++)
            {
                ans[p++]=i+1;
                ans[p++]=-(i+1);
            }
            return ans;
        }
    }
}

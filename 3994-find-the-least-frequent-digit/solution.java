class Solution {
    public int getLeastFrequentDigit(int n) {
        int f[]=new int[10];
        int mini=(int)Integer.MAX_VALUE, ans=-1;
        while(n>0){
            int digit=n%10;
            f[digit]++;
            n/=10;
        }
        for(int i=0;i<=9;i++){
          if(f[i]!=0 && f[i]<mini){
              mini=f[i];
              ans=i;
          }  
        } 
        return ans;
    }
}

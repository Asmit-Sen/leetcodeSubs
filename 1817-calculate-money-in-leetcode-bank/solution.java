class Solution {
    public int totalMoney(int n) {
        int s=1, sum=0;
        while(n>=7){
            sum+= 7*(2*s+6)/2;
            //sum of 7 terms from s
            n-=7;
            s++;
        }
        //last n terms starting from s
        sum+=n*(2*s+n-1)/2;
        return sum;
    }
}

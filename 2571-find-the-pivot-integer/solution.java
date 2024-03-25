class Solution {
    public int pivotInteger(int n) {
        int sum1=(n*(n+1))/2,sum2=n;
        int x=n;
        while(sum1>=sum2)
        {
            if(sum1==sum2) return x;
            x--;
            sum1=(x*(x+1))/2;
            sum2+=x;
        }
        return -1;
    }
}

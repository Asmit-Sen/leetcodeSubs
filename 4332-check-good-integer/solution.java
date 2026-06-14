class Solution {
    static int f(int n, int p){
        int sum=0;
        while(n>0){
            sum += Math.pow(n%10,p);
            n/=10;
        }
        return sum;
    }
    public boolean checkGoodInteger(int n) {
        return (f(n,2) - f(n,1) >= 50);
    }
}

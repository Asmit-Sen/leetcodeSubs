class Solution {
    long sum(long n){
        long sum = 0;
        while(n>0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
    long extract(long n){
        if (n<=9) return n;

        long d = n%10;
        if (d==0) return extract(n/10);
        return extract(n/10) * 10 + d;        
    }
    public long sumAndMultiply(int n) {
        long res = extract(n);
        return  res * sum(res);
    }
}

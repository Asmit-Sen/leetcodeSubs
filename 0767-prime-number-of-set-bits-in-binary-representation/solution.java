class Solution {
    public int countPrimeSetBits(int left, int right) {
        int isPrime[] = new int[right+1];

        Arrays.fill(isPrime, 1);
        isPrime[0]=0;
        isPrime[1]=0;

        for(int i=2; i*i<=right+1;i++){
            if (isPrime[i]==1){
                for(int j=i*i; j<right+1; j+=i){
                    isPrime[j]=0;
                }
            }
        }

        int ans = 0;
        for(int i=left; i<=right; i++){
            if (isPrime[Integer.bitCount(i)]==1) ans++;
        }

        return ans;
    }
}

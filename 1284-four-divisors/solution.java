class Solution {
    public int sumFourDivisors(int[] nums) {
        int n=(int)1e5;

        int seive[] = new int[n+1];
        Arrays.fill(seive,1);

        for(int i=2; i*i<=n; i++){
            if(seive[i]==1){
                // this number is a prime, 
                // mark all its multiples as non prime
                for(int j = i*i; j <= n; j += i) 
                    seive[j]=0;
            }
        }

        // for(int x:seive) System.out.print(x+", ");

        int sum=0;
        for(int num : nums){
            for(int i=2; i*i<=num-1; i++ ){
                if ((num%i==0 && seive[i]==1 && seive[num/i]==1) || 
                (seive[i]==1 && (int)Math.pow(i,3)==num))
                    sum+=1+num+(num/i)+i;
            }
        }

        return sum;
    }
}

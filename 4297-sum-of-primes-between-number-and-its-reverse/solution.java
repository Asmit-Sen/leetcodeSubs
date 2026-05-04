class Solution {
    int reverse(int n){
        int r=0;
        while(n!=0){
            r = r*10+n%10;
            n/=10;
        }
        return r;
    }
    public int sumOfPrimesInRange(int n) {
        int rev = reverse(n);

        int l = Math.min(n,rev);
        int h = Math.max(n,rev);

        int seive[]=new int[h+1];
        Arrays.fill(seive,1);
        seive[0]=seive[1]=0;
        
        for(int i=2;i*i<=h;i++){
            if (seive[i]==1){
                for(int j=i*i;j<=h;j+=i){
                    seive[j]=0;
                }
            }
        }
        // for(int x:seive) System.out.print(x+",");
        int ans = 0;
        for(int i=l;i<=h;i++) ans+= seive[i]==1 ? i : 0;

        return ans;
    }
}

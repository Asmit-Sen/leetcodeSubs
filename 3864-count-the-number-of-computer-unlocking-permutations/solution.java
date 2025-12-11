class Solution {
    public int countPermutations(int[] complexity) {
        
        if (complexity.length==1) return 1;
        if (complexity.length==2 && complexity[0]==complexity[1]) return 0;

        int mod=(int)1e9+7, n=complexity.length;
        long ans=1;
        for(int i=1;i<n;i++) {
            if (complexity[i]<=complexity[0]) return 0;
            ans=((long)ans*i) % mod;
        }

        return (int)ans; 
    }
}

class Solution {
    public int smallestRepunitDivByK(int k) {
        if ((k&1)==0) return -1;
        int rem=0, cnt=0;

        boolean f[]=new boolean[k];
        Arrays.fill(f,false);
        
        while(cnt++>=0){
            rem=(rem*10+1)%k;
            // System.out.println(rem);
            if(rem==0) return cnt;
            if(f[rem]) break;
            f[rem]=true;
        }
        
        return -1;
    }
}

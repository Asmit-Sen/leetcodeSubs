class Solution {
    public int bitwiseComplement(int n) {
        int m=n, c=0, ans=0;
        while(m!=0){
            m=m>>1;
            c++;
        }
        int mask=1;
        for(int i=1;i<c;i++){
            mask=(mask<<1)+1;
        }

        // System.out.println(mask);
        
        ans = mask ^ n;
        return ans;
    }
}

class Solution {
    int gcd(int x, int y){
        if (x<y) return gcd(y,x);

        if (y==0) return x;
        return gcd(y, x%y);
    }
    public long gcdSum(int[] nums) {
        int n=nums.length;
        int maxi[]=new int[n];
        int pre[]=new int[n];

        maxi[0]=nums[0];
        for(int i=1;i<n;i++) maxi[i]=(int)Math.max(maxi[i-1], nums[i]);

        for(int i=0;i<n;i++) pre[i]=gcd(maxi[i], nums[i]);

        Arrays.sort(pre);

        // for(int x : maxi) System.out.print(x);
        // for(int x : pre) System.out.print(x);

        long ans=0;
        for(int i=0;i<n/2;i++)
                ans+=gcd(pre[i], pre[n-i-1]);

        return ans;
    }
}

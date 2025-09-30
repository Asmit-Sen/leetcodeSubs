class Solution {
    public long flowerGame(int n, int m) {
        // int c=0;
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=m;j++){
        //         if((i+j)%2==1) c++;
        //     }
        // }
        // return c;

        //no of pairs where odd sum occurs is when 
        // (x odd , y even) + (x even , y odd)

        long x_odd=(int)Math.ceil(n/2.0);
        long y_even=(int)Math.floor(m/2.0);

        long x_even=(int)Math.floor(n/2.0);
        long y_odd=(int)Math.ceil(m/2.0);

        return (long) (x_odd * y_even + x_even * y_odd);
        
        
    }
}

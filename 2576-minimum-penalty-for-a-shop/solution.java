class Solution {
    public int bestClosingTime(String customers) {

        // closed => y = 1 , n = 0
        // y y n y
        // 1 1 0 1
        // postfix sum
        // 3 2 1 1 0

        // open => y = 0 , n = 1
        // y y n y
        // 0 0 1 0
        //prefix sum (except current)
        // 0 0 0 1 1

        // 3 2 1 2 1
        //scan right to left and return the best index


        int ans=-1;
        int n=customers.length();
        int prefix[] =new int[n+1];
        int postfix[] = new int[n+1];

        postfix[n]=0;
        for(int i=n-1;i>=0;i--)
            postfix[i]=postfix[i+1] + ((customers.charAt(i)=='Y')?1:0);
        
        prefix[0]=0;
        for(int i=1;i<=n;i++)
            prefix[i]=prefix[i-1] + ((customers.charAt(i-1)=='Y')?0:1);

        int penalty=(int)1e9;
        for(int i=n;i>=0;i--){
            if (prefix[i]+postfix[i]<=penalty){
                penalty=prefix[i]+postfix[i];
                ans=i;
            }
        }
        return ans;

 
    }
}

class Solution {
    public int[] plusOne(int[] digits) {
        int carry=1,sum=0;
        int cnt=0;
        for(int i=digits.length-1;i>=0;i--)
        {
            sum=carry;
            sum+=digits[i];
            carry=sum/10;
            sum%=10;

            digits[i]=sum;
            cnt++;
        }

        if(digits[0]==0) //add a one carry
        {
            int ans[]=new int[cnt+1];
            Arrays.fill(ans,0);
            ans[0]=1;
            return ans;
        }
        return digits;
    }
}

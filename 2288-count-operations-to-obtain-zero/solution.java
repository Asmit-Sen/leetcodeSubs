class Solution {
    public int countOperations(int num1, int num2) {
        if (num1==num2) return num1==0? 0:1;
        int c=0, q=0;
        while(num1!=0 && num2!=0){
            if (num1>=num2) {
                q=num1/num2;
                num1%=num2;
                c+=q;
            }
            else {
                q=num2/num1;
                num2%=num1;
                c+=q;
            }
        }
        return c;
    }
}

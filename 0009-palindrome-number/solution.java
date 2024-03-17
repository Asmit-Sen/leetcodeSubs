class Solution {
    public boolean isPalindrome(int x) {
        int r=0,y=x;
        while(x>0)
        {
            r=r*10+x%10;
            x/=10;
        }
        if(r==y) return true; 
        else return false;
    }
}

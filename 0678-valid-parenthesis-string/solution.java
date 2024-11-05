class Solution {
    public boolean checkValidString(String s) {
        int min=0,max=0;
        for(char ch:s.toCharArray())
        {
            if(ch=='*') 
            {
                // worst case if itake it as a ')'
                min--;
                // best case if i take it as a'('
                max++;
            }
            if(ch=='(')
            {
                //have to take
                min++;
                max++;
            }
            if(ch==')')
            {
                //have to take
                min--;
                max--;
            }
            if(max<0) return false;
            if(min<0) min=0;
        }
        return (min==0);    
    }
}

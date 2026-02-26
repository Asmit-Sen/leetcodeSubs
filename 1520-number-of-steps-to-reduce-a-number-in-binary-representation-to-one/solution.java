class Solution {
    public int numSteps(String s) {
        int ans=0;
        
        StringBuilder str = new StringBuilder(s);
        while(!(str.length()==1 && str.charAt(0)=='1')){
            int n = str.length();
            ans++;
            if(str.charAt(n-1)=='0'){
                // even 
                // 1000 = 16
                // 100 = 8
                str.deleteCharAt(n-1);
            }
            else{
                // 100001
                // 100010
                // keep turning them 0 until a zero is found, which turns to a 1 instead
                // is its all ones, add an extra 1 at the start
                boolean flag=false;
                for(int i=n-1;i>=0;i--){
                    if (str.charAt(i)=='1') 
                        str.replace(i,i+1,"0");
                    else {
                        str.replace(i,i+1,"1");
                        flag=true;
                        break;
                    } 
                }
                if(!flag) {
                    StringBuilder one = new StringBuilder("1");
                    one.append(str);
                    str=one;
                } 
            }
        }

        return ans;
    }
}

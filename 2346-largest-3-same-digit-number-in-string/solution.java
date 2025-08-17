class Solution {
    public String largestGoodInteger(String num) {
        int maxi=-1;
        String ans="";
        for(int i=1;i<num.length()-1;i++){
            char c=num.charAt(i);
            if(num.charAt(i)==num.charAt(i-1) && num.charAt(i)==num.charAt(i+1)){
                if(c>maxi)
                {
                    ans=new StringBuilder(c+""+c+""+c).toString();
                    maxi=c;
                }
            }
        }
        return ans;
    }
}

class Solution {
    
    public String processStr(String s) {
        StringBuilder str = new StringBuilder();
        for(char c:s.toCharArray()){
            switch (c){
                case '*': 
                    if (!str.isEmpty()) str.deleteCharAt(str.length()-1);    
                    break;
                case '#': 
                    str.append(str);
                    break;
                case '%': 
                    str = str.reverse();
                    break;
                default : str.append(c);
            }
        }

        return str.toString();
    }
}

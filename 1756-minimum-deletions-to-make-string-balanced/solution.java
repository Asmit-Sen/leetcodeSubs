class Solution {
    public int minimumDeletions(String s) {
        // all a shoud=ld come before all b

        //  for any index[i],
        // if char == a  
        // delete this a or del a previous b
        // either way count_of_del++
        // count_of_b--

        // if char == b  
        // count_of_b++

        int del=0, cnt=0;
        for(char c : s.toCharArray()){
            if(c=='a'){
                if(cnt>0){
                    cnt--;
                    del++;
                }
            }
            else cnt++;
        }
        return del;
    }
}

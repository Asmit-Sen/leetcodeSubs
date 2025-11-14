class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        Stack<Integer> st = new Stack<>();
        for(char c:s.toCharArray()){
            int curr=map.get(c);
            if(!st.isEmpty()){
                    if (st.peek()>=curr)
                        st.push(curr);
                    else {
                        int top=st.pop();
                        st.push(curr-top);
                    }
            } else
                st.push(curr);
        }
        
        int ans=0;
        while(!st.isEmpty())
            ans+=st.pop();
        
        return ans;

        
    }
}

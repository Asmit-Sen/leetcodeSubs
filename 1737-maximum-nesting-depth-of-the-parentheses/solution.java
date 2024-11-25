class Solution {
    public int maxDepth(String s) {
        Stack<Character> st=new Stack<>();
        int maxi=0;
        for(char ch:s.toCharArray())
        {
            if(ch=='(')
            st.push(ch);

            if(ch==')')
            {
                maxi=(int)Math.max(maxi,st.size());
                st.pop();
            }
            
        }
        return maxi;
    }
}

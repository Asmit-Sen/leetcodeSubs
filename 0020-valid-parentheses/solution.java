class Solution {
    public boolean isValid(String s) {
Stack<Character> st = new Stack<Character>();
        for (int i=0;i<s.length();i++) {
            char it=s.charAt(i);
            if (it == '(' || it == '[' || it == '{')
                st.push(it);
            else {
                if(st.isEmpty()) return false;
                char ch = st.pop(); 
                if((it == ')' && ch == '(') ||  (it == ']' && ch == '[') || (it == '}' && ch == '{')) continue;
                else return false;
            }
        }
        return st.isEmpty();
    }
}

class Solution {
    public int countCollisions(String directions) {
        Stack <Character> st = new Stack<>();
        st.push(directions.charAt(0));

        int n=directions.length();
        char[] dir= directions.toCharArray();
        int ans=0;

        for(int i=1;i<n;i++){
            if(dir[i]=='L' && st.peek()=='S') {
                ans+=1;
                continue;
            }
            if(dir[i]=='S' && !st.isEmpty() &&  st.peek()=='R') {
                while(!st.isEmpty() && st.pop()=='R')
                    ans+=1;
                st.push('S');
                continue;
            }
            if(dir[i]=='L' && !st.isEmpty() && st.peek()=='R') {
                ans+=2;
                st.pop();
                while(!st.isEmpty() && st.pop()=='R')
                    ans+=1;
                st.push('S');
                continue;
            }

            //else its safe
            st.push(dir[i]);
        }
        return ans;
    }
}

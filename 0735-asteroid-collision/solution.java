class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack <Integer> st=new Stack<>();
        for(int asteroid:asteroids)
        {
            if(asteroid>0)
            st.push(asteroid);
            else
            {
                while(!st.isEmpty() && st.peek()>0 && st.peek()<(int)Math.abs(asteroid))
                st.pop();

                if(st.isEmpty() || st.peek()<0) st.push(asteroid);
                else if(st.peek()==(int)Math.abs(asteroid)) 
                {
                    st.pop();
                }
                else continue;
            }
        }
        System.out.println(st);
        int arr[]=new int[st.size()];
        for(int i=st.size()-1;i>=0;i--)
        arr[i]=st.pop();
        return arr;
    }
}

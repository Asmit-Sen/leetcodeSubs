class Solution {
    public int largestRectangleArea(int[] arr) {
        Stack <Integer> st=new Stack<>();
        //pse and nse index
        int pse, nse, maxi=0;
        for(int i=0;i<arr.length;i++)
        {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]) 
            {
                int top=arr[st.pop()];
                nse=i;
                pse=st.isEmpty()?-1:st.peek();

                maxi=(int)Math.max(maxi,(nse-pse-1)*top);
            }
            st.push(i);
        }
        while(!st.isEmpty())
        {
            int top=arr[st.pop()];
            nse=arr.length;
            pse=st.isEmpty()?-1:st.peek();

            maxi=(int)Math.max(maxi,(nse-pse-1)*top);
        }
        return maxi;
    }
}

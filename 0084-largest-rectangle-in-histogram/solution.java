class Solution {
    public int largestRectangleArea(int[] arr) {
        int n=arr.length, maxi=0;
        Stack <Integer> stack=new Stack<>();
        // int pse[]=new int[n];
        // int nse[]=new int[n];
        int nse,pse;
        for(int i=0;i<n;i++)
        {
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i])
            {
                //before popping do calc
                int top=stack.peek();
                stack.pop();

                nse=i;
                pse=stack.isEmpty()?-1:stack.peek();;
                maxi=(int)Math.max(maxi,(nse-pse-1)*arr[top]);
                
            }
            stack.push(i);
        }

        while(!stack.isEmpty())
        {
            int top=stack.peek();
            stack.pop();
            
            nse=n;
            pse=stack.isEmpty()?-1:stack.peek();
            maxi=(int)Math.max(maxi,(n-pse-1)*arr[top]);
    
            
        }
        return maxi;

    }
}

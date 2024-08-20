class Solution {
    public String removeKdigits(String num, int k) {

        // if its a single num AND k=1 ans is 0 always
        if(num.length()==k) return "0";

        int n=num.length(), top=-1;
        Stack <Character> stack = new Stack<>();

        for(int i=0;i<n;i++)
        {
            char d=num.charAt(i);
            while(!stack.isEmpty() && k>0 && stack.peek()-'0'>d-'0')
            {
                stack.pop();
                k--;
            }
            stack.push(d);
        }

        while(k>0)
        {
            stack.pop();
            k--;
        }
        if(stack.isEmpty()) return "0";

        // reverse the resultant and remove leading zeroes
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());// keep adding popped ele at the front, hence reversed
        }

        // Remove leading zeros
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.toString();

        // int rev=0,pos=0;
        // while(!stack.isEmpty())
        // rev=stack.pop()*(int)Math.pow(10,pos++) + rev;
        // System.out.println(rev);
        // return Integer.toString(rev);
        // ???? Integer overflow
        
    }
}

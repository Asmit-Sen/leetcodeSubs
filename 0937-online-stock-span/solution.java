class StockSpanner {
    Stack <int[]> stack=new Stack<>();
    int ind;
    public StockSpanner() {
        stack.clear();
        ind=-1;
    }
    
    public int next(int price) {

        ind++;

        while(!stack.isEmpty() && stack.peek()[0]<=price)
        stack.pop();

        int span=stack.isEmpty()?ind+1:ind-stack.peek()[1];
        stack.push(new int[] {price,ind});
        
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

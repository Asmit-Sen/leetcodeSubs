class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        int n=friends.length;
        int ans[]=new int[n];
        int pos=0;
        Set<Integer> set= new HashSet<>();

        for(int x:friends) set.add(x);
        
        for(int x: order)
            if(set.contains(x)) ans[pos++]=x;
        return ans;
    }
}

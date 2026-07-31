class Solution {
    int fact(int n){
        if (n==0 || n==1) return 1;
        return n * fact(n-1);
    }
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++) list.add(i);

        int f = fact(n-1);
        StringBuilder ans = new StringBuilder();
        k--;

        int block = 0;
        while(true){
            block = k / f;
            int cur = list.get(block);
            ans.append(cur);

            
            list.remove(Integer.valueOf(cur));
            if(list.isEmpty()) break;

            k = k % f;
            f /= list.size();
        }
        return ans.toString();
    }
}

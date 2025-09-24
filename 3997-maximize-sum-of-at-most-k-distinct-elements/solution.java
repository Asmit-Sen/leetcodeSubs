class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        TreeSet<Integer> set= new TreeSet<>((a,b)->b-a);
        for(int x:nums) set.add(x);
        List<Integer>list= new ArrayList<>();
        for(int x:set){
            list.add(x);
            k--;
            if(k==0) break;
        }
        int ans[]=new int[list.size()];
        int p=0;
        for(int x:list) ans[p++]=x;
        return ans;
    }
}

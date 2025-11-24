class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int cur=0;
        List <Boolean> ans = new ArrayList<>();
        for(int x:nums){
            cur=((cur<<1)+x)%5;
            ans.add(cur==0);
        }
        return ans;
    }
}

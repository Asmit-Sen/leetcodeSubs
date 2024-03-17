class Solution {
    public int singleNumber(int[] nums) {
        int res=0;
        for (int it:nums)
        res=res^it;
        return res;
    }
}

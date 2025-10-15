class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int prev=0, cur=1, ans=0;
        for(int i=1;i<nums.size();i++){
            if(nums.get(i)>nums.get(i-1)) cur++;
            else{
                prev=cur;
                cur=1;
            }
            int len =(int)Math.max((int)Math.min(prev,cur),cur/2);
            ans=(int)Math.max(ans, len);
        }
        return ans;
    }
}

class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int prev=0, cur=1;
        for(int i=1;i<nums.size();i++){
            if(nums.get(i)>nums.get(i-1)) cur++;
            else{
                prev=cur;
                cur=1;
            }
            //if its a contiguous inc subarray of len == 2k or if both the prev and 
            //cur increasing subarrays ar eboth atleast = k 
            if(cur==2*k || (prev>=k && cur>=k)) return true;
        }
        return false;
    }
}

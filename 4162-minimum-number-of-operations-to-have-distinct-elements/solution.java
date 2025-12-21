class Solution {
    public int minOperations(int[] nums) {
        // 3 4 3 4 3 4 3 4
        
        int n=nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i=n-1;i>=0;i--){
            if(set.contains(nums[i])){
                return i/3 + 1;
            }
            set.add(nums[i]);
        }
        return 0;
    }
}

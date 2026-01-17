class Solution {
    public int minOperations(int[] nums, int[] target) {
        int n = nums.length;
        int c=0;

        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            if (nums[i]!=target[i]){
                if (set.contains(nums[i])) continue;
                else c++;
                set.add(nums[i]);
            }
        }

        return c;

    }
}

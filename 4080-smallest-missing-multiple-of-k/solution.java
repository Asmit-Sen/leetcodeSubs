class Solution {
    public int missingMultiple(int[] nums, int k) {
        // Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for(int x : nums) set.add(x);
        int i=1;
        for(i=1;i<=100;i++){
            if(!set.contains(k*i)) return k*i;
        }
        return k*i;
    }
}

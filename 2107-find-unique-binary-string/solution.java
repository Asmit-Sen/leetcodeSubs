class Solution {
    public String findDifferentBinaryString(String[] nums) {
        // Arrays.sort(nums);
        int n=nums.length;

        Set<String> set= new HashSet<>();
        for(String s:nums) set.add(s);

        String target="";
        for(int i=0;i<n;i++){
            target = nums[0].substring(0,i) + 
            ((nums[0].charAt(i)=='1')?"0":"1") + nums[0].substring(i+1);
            if (!set.contains(target)) return target;
            target="";
        }

        return "";
    }
}

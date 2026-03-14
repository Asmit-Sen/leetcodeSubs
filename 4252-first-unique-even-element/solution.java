class Solution {
    public int firstUniqueEven(int[] nums) {
        int f[]=new int[101];
        for(int x:nums) f[x]++;

        for(int i=0;i<nums.length;i++)
                if(f[nums[i]]==1 && ((nums[i]&1)==0)) return nums[i];
        
        return -1;
    }
}

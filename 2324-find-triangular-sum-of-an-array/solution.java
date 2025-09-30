class Solution {
    public int triangularSum(int[] nums) {
        int n=nums.length;
        // List<Integer> list= new ArrayList<>();
        int curr[]=new int[n];
        for(int i=1;i<n;i++){
            for(int j=i;j<n;j++){
                curr[j]=(nums[j]+nums[j-1])%10;
            }
            nums=curr.clone();
        }
        return nums[n-1];
    }
}

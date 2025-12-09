class Solution {
    public int specialTriplets(int[] nums) {
        long c=0;
        int mod=(int)1e9+7;

        Map <Integer,Integer> total = new HashMap<>();
        Map <Integer,Integer> before = new HashMap<>();

        for(int x:nums) total.put(x,total.getOrDefault(x,0)+1);

        for(int i=0;i<nums.length;i++){
            int target=2*nums[i];

            int left = before.getOrDefault(target,0);
            before.put(nums[i], before.getOrDefault(nums[i],0)+1);
            int right = total.getOrDefault(target,0) - before.getOrDefault(target,0);

            if(left>=1 && right>=1)
                c=(c+(long)left*right)%mod;

        }
        return (int)c;
    }
}

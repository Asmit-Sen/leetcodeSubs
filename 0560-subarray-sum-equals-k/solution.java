class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0,c=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            int target=sum-k;
            if(map.containsKey(target)) c+=map.get(target);

            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return c;
    }
}

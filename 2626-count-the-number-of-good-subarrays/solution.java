class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();

        int l=0,r=0,f=0;
        long cnt=0,totalPairs=0;
        while(r<nums.length){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            f=map.get(nums[r]);
            // if(f>=2) pairs=f*(f-1)/2;
            totalPairs+=f-1;

            while(totalPairs>=k && l<r){
                cnt+=nums.length-r;
                f=map.get(nums[l]);
                totalPairs-=f-1;
                map.put(nums[l],map.get(nums[l])-1);
                l++;
            }

            r++;
        }
        return cnt;
    }
}

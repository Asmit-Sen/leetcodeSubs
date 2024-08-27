class Solution {
    public int subarraySum(int[] arr, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        int sum=0,target=0,cnt=0;
        map.put(0,1);

        for(int num:arr)
        {
            sum+=num;
            target=sum-k;

            if(map.containsKey(target))
            cnt+=map.get(target);

            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
}

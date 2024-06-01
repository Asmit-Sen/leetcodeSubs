class Solution {
    public int subarraySum(int[] arr, int k) {
        HashMap <Integer,Integer> map= new HashMap<>();
        map.put(0,1);
        int sum=0,cnt=0;

        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            int target=sum-k;
            if(map.containsKey(target))
            {
                cnt+=map.get(target);
            }
            if(map.containsKey(sum)) map.put(sum,map.get(sum)+1);
            else map.put(sum,1);
        }
        return cnt;
    }
}

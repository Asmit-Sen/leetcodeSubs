class Solution {
    public int subarraySum(int[] arr, int k) {
        Map <Integer,Integer> map=new HashMap<>();
        int prefixsum=0,sum=0,c=0;
        map.put(0,1);
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            prefixsum=sum-k;
            if(map.containsKey(prefixsum)) c+=map.get(prefixsum);
            if(map.containsKey(sum))
            map.put(sum,map.get(sum)+1);
            else map.put(sum,1);
        }
        return c;
    }
}

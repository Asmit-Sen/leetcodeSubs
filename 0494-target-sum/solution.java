class Solution {
    int f(int i, int target, int arr[],Map<String,Integer> map)
    {
        String key=i+","+target;
        if(map.containsKey(key)) return map.get(key);

        if(i==0)
        {
            if(arr[i]==0 && target==0) return 2;
            else if(arr[i]==target || arr[i]==target*-1) return 1;
            else return 0;
        }

        int l=f(i-1,target-arr[i],arr,map);
        int r=f(i-1,target+arr[i],arr,map);
        map.put(key,(l+r));
        return l+r;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return f(nums.length-1,target,nums,new HashMap<>());
    }
}

class Solution {
    int count(int arr[], int k)
    {
        if(k<0) return 0;

        Map <Integer, Integer> map=new HashMap<>();
        int l=0,r=0,cnt=0;

        while(r<arr.length)
        {
            map.put(arr[r],map.getOrDefault(arr[r],0)+1);
            while(map.size()>k)
            {
                map.put(arr[l],map.get(arr[l])-1);
                if(map.get(arr[l])==0) map.remove(arr[l]);
                l++;
            }
            cnt+=r-l+1;
            r++;
        }
        return cnt;
    }
    public int subarraysWithKDistinct(int[] arr, int k) {
        return count(arr,k)-count(arr,k-1);
    }
}

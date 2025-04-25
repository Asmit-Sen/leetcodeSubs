class Solution {

    int f(int arr[], int k){
        if(k<=0) return 0;

        Map<Integer,Integer> map=new HashMap<>();
        //digit <-> frq

        int l=0,r=0,cnt=0,n=arr.length;
        while(r<n){
            map.put(arr[r],map.getOrDefault(arr[r],0)+1);
            
            while(map.size()>k){
                //shrink window and get down to exactly k distinct ele
                map.put(arr[l],map.get(arr[l])-1);
                if(map.get(arr[l])==0) map.remove(arr[l]);
                l++;
            }

            if(map.size()<=k) cnt+=r-l+1;
            r++;
        }
        return cnt;
    }
    public int countCompleteSubarrays(int[] nums) {

        //first count no of distinct ele in the whole array = k
        //return no ubarray with exactly k distinct elements
        // ans= f(k)-f(k-1)
        // f(k) -> no of subarray with atmost k distinct ele

        Set<Integer> set=new HashSet<>();
        for(int x:nums) set.add(x);

        int k=set.size();
        System.out.println(k);
        return f(nums,k)-f(nums,k-1);
        
    }
}

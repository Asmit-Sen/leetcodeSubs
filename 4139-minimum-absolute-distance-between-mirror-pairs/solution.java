class Solution {
    static int rev (int n){
        int ans = 0;
        while(n!=0){
            ans = ans * 10 + n % 10;
            n/=10;
        }
        return ans;
    }
    public int minMirrorPairDistance(int[] nums) {
        // 12 44 21 65 12 21
        // 21 44 12 56 21 12

        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int ans=(int)1e9;
        for(int i=0;i<n;i++){
            int rev = rev(nums[i]);
            if (map.containsKey(nums[i]))  ans = Math.min(ans, i - map.get(nums[i])); 
            map.put(rev, i);
        }
        return ans==(int)1e9?-1:ans;
    }
}

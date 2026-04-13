class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if (map.get(nums[i])==null) 
                map.put(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        int ans=(int)1e6;
        for(int n : map.keySet()){
            if (map.get(n).size()<3) continue;
            for(int j = 0; j <= map.get(n).size()-3; j++){
                int x = map.get(n).get(j);
                int y = map.get(n).get(j+1);
                int z = map.get(n).get(j+2);

                int dx = (int)Math.abs(x-y); 
                int dy = (int)Math.abs(z-y); 
                int dz = (int)Math.abs(x-z); 
                
                ans = (int)Math.min(ans, dx + dy + dz );
                // System.out.println(ans);
            }
        }
        // for(int k : map.keySet()){
        //     System.out.println(k + "=" + map.get(k));
        // }
        return ans==(int)1e6 ? -1 : ans;
    }
}

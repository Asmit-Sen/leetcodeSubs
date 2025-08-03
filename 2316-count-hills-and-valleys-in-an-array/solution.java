class Solution {
    public int countHillValley(int[] nums) {
        if(nums.length<=2) return 0;

        //ignore adjacent duplicates so that while tracking, hills and valleys are counted once
        int n=nums.length;
        List<Integer> list= new ArrayList<>();

        for(int i=0;i<n;i++){
            if(i==0 || nums[i]!=nums[i-1]) list.add(nums[i]);
        }

        int c=0;
        for(int i=1;i<list.size()-1;i++){
            if(list.get(i)> list.get(i-1) && list.get(i)>list.get(i+1)) c++;
            if(list.get(i)< list.get(i-1) && list.get(i)<list.get(i+1)) c++;
        }
        return c;
    }
}

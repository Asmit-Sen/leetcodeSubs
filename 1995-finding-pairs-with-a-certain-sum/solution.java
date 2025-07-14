class FindSumPairs {

    //store freq of elements in arr2
    Map <Integer, Integer> map= new HashMap<>();
    int nums1[], nums2[];

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1=nums1;
        this.nums2=nums2;

        for(int num:nums2) 
            map.put(num,map.getOrDefault(num,0)+1);
    }
    
    public void add(int index, int val) {
        int el = this.nums2[index];

        //update freq of old el
        map.put(el,map.get(el)-1);

        //update freq of new el
        this.nums2[index]+=val;
        el = this.nums2[index];
        map.put(el, map.getOrDefault(el,0)+1);
    }
    
    public int count(int tot) {
        int ans=0;
        for(int num:nums1){
            ans+=map.getOrDefault(tot-num,0);
        }
        return ans;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */

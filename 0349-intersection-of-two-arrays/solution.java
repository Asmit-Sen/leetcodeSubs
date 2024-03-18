class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet <Integer> set =new HashSet<>();

        for (int i=0;i<nums2.length;i++)
        set.add(nums2[i]);

        HashSet <Integer> c=new HashSet<>();
        for (int i=0;i<nums1.length;i++)
        if(set.contains(nums1[i])) c.add(nums1[i]);

        int res[]=new int[c.size()];
        Iterator <Integer> it=c.iterator();
        int p=0;
        while(it.hasNext())
        res[p++]=it.next();

        return res;


    }
}

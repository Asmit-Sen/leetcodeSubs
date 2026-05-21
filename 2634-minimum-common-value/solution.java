class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int l = 0, r = 0;
        int n = nums1.length, m = nums2.length;
        while(l < n && r < m){
            if (nums1[l] == nums2[r]) return nums1[l];

            if (nums1[l]<nums2[r]) l++;
            else r++;
        }
        return -1;
    }
}

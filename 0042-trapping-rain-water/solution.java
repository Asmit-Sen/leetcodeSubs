class Solution {
    public int trap(int[] height) {
        int lmax=0, rmax=0, ans=0;
        int l=0, r=height.length-1;
        while(l<=r){
            if(height[l]<=height[r]){
                //then height[r] serves as my right boundary
                //process water above me based on lmax

                if(lmax>height[l])
                ans+=lmax-height[l];
                else
                lmax=(int)Math.max(lmax,height[l]);

                l++;
            }
            else
            {
                //then height[l] serves as my left boundary
                //process water above me based on rmax

                if(rmax>height[r])
                ans+=rmax-height[r];
                else
                rmax=(int)Math.max(rmax,height[r]);

                r--;
            }
        }
        return ans;
    }
}

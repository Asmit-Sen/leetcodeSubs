class Solution {
    public int maxArea(int[] height) {

        int area=Integer.MIN_VALUE, max=Integer.MIN_VALUE;
        int left=0, right=height.length-1;
        while(left<right)
        {
            area=(int) Math.min(height[left],height[right])*(right-left);
            max=(int)Math.max(max,area);
            if(height[left]<height[right]) left++;
            else right--;
        }
        return max;
        
    }
}

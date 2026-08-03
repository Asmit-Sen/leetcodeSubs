class Solution {
    boolean f(int l, int r, int turn, int a, int b, int nums[]){
        if (l>r) return a>=b;

        boolean x = false, y = false;

        if (turn==0){
            // a takes left
             x = f(l+1, r, 1, a+nums[l], b, nums);
            // a takes right
             y = f(l, r-1, 1, a+nums[r], b, nums);
             
            return x | y;
        }
        else {
            // b takes left
             x = f(l+1, r, 0, a, b+nums[l], nums);
            // a takes right
             y = f(l, r-1, 0, a, b+nums[r], nums);
             
            return x & y;
        }
    }
    public boolean predictTheWinner(int[] nums) {
        return f(0, nums.length-1, 0, 0, 0, nums);
    }
}

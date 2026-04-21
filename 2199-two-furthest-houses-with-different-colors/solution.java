class Solution {
    public int maxDistance(int[] colors) {
        // store the first occurences of all colors
        int ans = 1;
        int n = colors.length;
        for(int i=0;i<colors.length;i++){
            if (colors[i] != colors[0]) ans = Math.max(ans, i);
            if (colors[n-i-1] != colors[i]) ans = Math.max(ans, n-i-1);
        }
        return ans;
    }
}

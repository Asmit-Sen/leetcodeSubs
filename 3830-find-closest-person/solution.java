class Solution {
    public int findClosest(int x, int y, int z) {
        if ((int)Math.abs(z-x)<(int)Math.abs(z-y))
        return 1;
        else if ((int)Math.abs(z-x)>(int)Math.abs(z-y))
        return 2;

        return 0;
    }
}

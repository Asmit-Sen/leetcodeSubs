class Solution {
    public int findContentChildren(int[] greed, int[] cookie) {
        Arrays.sort(greed);
        Arrays.sort(cookie);

        int j=0,i=0;
        while(i<cookie.length && j<greed.length)
        {
            if(greed[j]<=cookie[i]) j++;
            i++;
        }
        return j;
    }
}

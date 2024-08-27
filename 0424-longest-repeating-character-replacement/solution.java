class Solution {
    public int characterReplacement(String s, int k) {
        int map[]=new int[26];
        Arrays.fill(map,0);

        int maxi=0,maxf=0,l=0,r=0;

        while(r<s.length())
        {
            map[s.charAt(r)-'A']++;
            maxf=(int)Math.max(maxf,map[s.charAt(r)-'A']);
            if((r-l+1)-maxf>k)
            {
                map[s.charAt(l)-'A']--;
                l++;
            }
            maxi=(int)Math.max(r-l+1,maxi);
            r++;
        }
        return maxi;
        
    }
}

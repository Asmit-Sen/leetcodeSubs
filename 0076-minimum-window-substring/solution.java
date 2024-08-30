class Solution {
    public String minWindow(String s, String t) {
        int map[]=new int[256];// stores which chars and how many of them is needed to form our substring
        int l=0,r=0,k=0,start=-1,mini=Integer.MAX_VALUE;


        for(int i=0;i<t.length();i++)
            map[t.charAt(i)]++;

        while(r<s.length())
        {
            if(map[s.charAt(r)]>0)
                k++; //if still needed, include it, and inc k
            map[s.charAt(r)]--;

            while(k==t.length())
            {
                if(r-l+1<mini)
                {
                    start=l;    
                    mini=r-l+1;
                }
                map[s.charAt(l)]++;
                if(map[s.charAt(l)]>0)
                    k--;
                l++;
            }
            r++;
        }
        return (start==-1)?"":s.substring(start,start+mini);
    }
}

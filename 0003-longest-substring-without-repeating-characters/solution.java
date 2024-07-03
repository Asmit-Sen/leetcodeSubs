class Solution {

    int sub(String s)
    {
        int hash[]=new int[256];
        for(int i=0;i<256;i++)
        hash[i]=-1;

        int l=0,r=0,cnt=0;
        while(l<=r && r<s.length())
        {
            int pos=hash[s.charAt(r)];
            if(pos>=l)
                l=pos+1;
            cnt=(int)Math.max(cnt,r-l+1);
            hash[s.charAt(r)]=r;
            r++;
        }
        return cnt;
        
    }
    public int lengthOfLongestSubstring(String s) {
        // Map <Character, Integer> map=new HashMap<>();
        // int l=0,r=0;
        // int max=0;
        // while(l<=r && r<s.length())
        // {
        //     System.out.println(s.substring(l,r));
            
        //     int pos=map.getOrDefault(s.charAt(r),-1);
        //     if(pos>=l) //char is found already
        //         l=pos+1;
        //     map.put(s.charAt(r),r);
        //     max=(int)Math.max(max,r-l+1);
        //     r++;
        // }
        return sub(s);
    }
}

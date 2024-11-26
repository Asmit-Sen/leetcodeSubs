class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        Map <String,Integer> map=new HashMap<>();
        k=s.length()/k;
        String str="";
        for(int i=0;i+k<=s.length();i+=k)
            {
                str=s.substring(i,i+k);
                map.put(str,map.getOrDefault(str,0)+1);
            }
        System.out.println(map);
        for(int i=0;i+k<=t.length();i+=k)
            {
                str=t.substring(i,i+k);
                if(!map.containsKey(str))
                return false;
                map.put(str,map.get(str)-1);
                if(map.get(str)==0)
                    map.remove(str);
            }   
        
        return map.isEmpty()?true:false;

        
    }
}

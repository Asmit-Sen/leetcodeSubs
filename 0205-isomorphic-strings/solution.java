class Solution {
    public boolean isIsomorphic(String s, String t) {
        char s1[]=s.toCharArray();
        char s2[]=t.toCharArray();

        Map<Character,Character> map=new HashMap<>();// pairs of chars in s1 and s2
        Set<Character> set=new HashSet<>();//set of all values of the map
        for(int i=0;i<s1.length;i++)
        {
            if(!map.containsKey(s1[i]))
            {
                if(set.contains(s2[i])) return false;
                map.put(s1[i],s2[i]);
                set.add(s2[i]);
            }

            if(map.get(s1[i])!=s2[i]) return false;
        }
        return true;

    }
}

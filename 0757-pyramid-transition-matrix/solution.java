class Solution {
    boolean foo(int i, String base, StringBuilder newBase, Map<String, List<Character>> map,
    Map<String, Boolean> dp ){
        if(base.length()==1) return true;
        if (i == base.length()-1){
            if (dp.containsKey(newBase)) return dp.get(newBase);
            boolean result = foo(0, newBase.toString(), new StringBuilder(), map, dp);
            dp.put(newBase.toString(), result);
            return result;
        }

        String pattern = base.substring(i, i+2);
        //look for all possible replacements

        if (!map.containsKey(pattern)) return false;
        List<Character> list = map.get(pattern);
        
        for(Character top : list){
            newBase.append(top);
            if (foo(i+1, base, newBase, map, dp) == true) return true;
            newBase.deleteCharAt(newBase.length()-1);
        }
        return false;
    }
    public boolean pyramidTransition(String bottom, List<String> allowed) {

        Map<String, List<Character>> map = new HashMap<>();
        for(String s : allowed){
            String pattern = s.substring(0,2);
            Character top = s.charAt(2);

            if(!map.containsKey(pattern)) map.put(pattern, new ArrayList<>());

            map.get(pattern).add(top);
        }

        // for(String x : map.keySet())
        //     System.out.println(x + ", " + map.get(x));

        Map<String, Boolean> dp = new HashMap<>();
        return foo(0, bottom, new StringBuilder(), map, dp);
    }
}

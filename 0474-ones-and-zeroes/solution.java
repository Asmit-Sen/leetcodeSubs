class Solution {
    int f(int i, int zero, int one, List<int[]> list, int m, int n, HashMap<String, Integer> map){
        if(i==list.size()) return 0;

        String key=i+","+one+","+zero;
        if(map.containsKey(key)) return map.get(key);

        int take=0, nottake=0;
        nottake=f(i+1, zero, one, list, m, n, map);

        int s[]=list.get(i);
        int zeroes=s[0], ones=s[1];
        if(zero+zeroes<=m && one+ones<=n) take= 1 + f(i+1, zero+zeroes , one+ones ,list, m, n, map);

        int val=(int)Math.max(take,nottake);
        map.put(key,val);
        return val;
    }
    int[] count(String str){
        int ones=0, zeroes=0;
        for(char c:str.toCharArray()) if(c=='1') ones++;
        else zeroes++;

        return new int[]{zeroes,ones};
    }
    public int findMaxForm(String[] strs, int m, int n) {
        List<int[]> list = new ArrayList<>();
        for(String s: strs) list.add(count(s));

        return f(0,0,0,list,m,n,new HashMap<>());
    }
}

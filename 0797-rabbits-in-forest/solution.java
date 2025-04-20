class Solution {
    public int numRabbits(int[] answers) {
        Arrays.sort(answers);
        Map<Integer,Integer> map =new HashMap<>();

        //f[i]-> can have a group of f[i]+1 at most
        for(int color:answers){
            map.put(color,map.getOrDefault(color,0)+1);
        }
        int n=0;
        // System.out.println(map);
        for(int color:map.keySet()){
            int groups=(int)Math.ceil((double)map.get(color)/(color+1));
            n+=groups*(color+1);
        }
        return n;
    }
}

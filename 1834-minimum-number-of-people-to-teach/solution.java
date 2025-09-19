class Solution {
    boolean common(int u, int v, int languages[][]){
        Set<Integer> set= new HashSet<>();
        for(int i:languages[u]){
            set.add(i);
        }
        for(int j:languages[v])
            if(set.contains(j)) return true;
        return false;
    }                       
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> list=new HashSet<>();

        for(int pair[]: friendships){
            int u=pair[0];
            int v=pair[1];

            if(!common(u-1,v-1,languages)){
                list.add(u-1);
                list.add(v-1);
            }
        }

        int f[]=new int[n+1];
        int maxi=0;
        for(int friend : list){
            for(int l:languages[friend]){
                f[l]++;
                maxi=(int)Math.max(maxi,f[l]);
            }
        }
        for(int fr : f) System.out.print(fr);
        System.out.println();

        System.out.println(maxi);
        
        return list.size()-maxi;
    }
}

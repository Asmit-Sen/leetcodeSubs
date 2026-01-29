class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        //build graph with chars from original and changed

        
        int adj[][] = new int[26][26];
        for(int row[]: adj) Arrays.fill(row, (int)1e9);
        for(int i=0;i<26;i++) adj[i][i]=0;

        for(int i=0;i<original.length;i++){
            //take tha min cost as the transitions may repeat
            adj[original[i]-'a'][changed[i]-'a'] = 
            (int)Math.min(adj[original[i]-'a'][changed[i]-'a'],cost[i]);
        }

        // run floyd warshall to know the min cost
        // to go from eveyr char to every other char

        for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    if (adj[i][k] + adj[k][j] < adj[i][j])
                        adj[i][j] = adj[i][k] + adj[k][j];
                }
            }
        }

        long ans=0;
        for(int i=0;i<source.length();i++){
            if(source.charAt(i)!=target.charAt(i))
                {
                    if (adj[source.charAt(i)-'a'][target.charAt(i)-'a']==(int)1e9)
                        return -1;
                    ans+=adj[source.charAt(i)-'a'][target.charAt(i)-'a'];
                }
        }

        return ans;
    }
}

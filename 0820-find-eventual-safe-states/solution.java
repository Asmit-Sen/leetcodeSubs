class Solution {
    boolean dfs(int i, int vis[], int path[], int graph [][]){
        vis[i]=1;
        path[i]=1;

        for(int nbr:graph[i]){
            if(path[nbr]==1) return true;
            else if(vis[nbr]==0){
                if(dfs(nbr,vis,path,graph)==true){
                    return true;
                }
            }
        }
        path[i]=0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int vis[]=new int[graph.length];
        int path[]=new int[graph.length];
        

        for(int i=0;i<graph.length;i++){
            if(vis[i]==0)
                dfs(i,vis,path,graph);
        }

        List<Integer> safe=new ArrayList<>();
        for(int i=0;i<path.length;i++){
            if(path[i]==0) safe.add(i);
        }
        return safe;
    }
}

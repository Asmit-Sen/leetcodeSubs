class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> q=new LinkedList<>();
        int m=graph.length;
        int vis[]=new int[m];
        Arrays.fill(vis,-1);
        

        for(int i=0;i<m;i++){
                if(vis[i]==-1){
                    //bfs
                    q.offer(i);
                    vis[i]=1;
                    
                    while(!q.isEmpty()){
                    int cur=q.poll();

                    for(int nbr:graph[cur]){
                        if(vis[nbr]==-1) {
                            vis[nbr]=vis[cur]^1;
                            q.offer(nbr);
                        }
                        else if(vis[nbr]==vis[cur]) return false;
                    }
                }
            }
        }
        return true;

    }
}

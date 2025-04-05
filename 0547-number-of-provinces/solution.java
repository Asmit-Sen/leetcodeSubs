class Solution {
    public int findCircleNum(int[][] adj) {
        Queue<Integer> q=new LinkedList<>();
        int n=adj.length;
        int vis[]=new int[n+1];

        int c=0;
        
        for(int node=0;node<n;node++){
            if(vis[node]==0) {
                c++;
                q.offer(node);
                vis[node]=1;

                while(!q.isEmpty()){
                    int i=q.peek();
                    for(int j=0;j<n;j++){
                        if(adj[i][j]==1 && i!=j){
                            // edge present
                            if(vis[j]==0){
                                vis[j]=1;
                                q.offer(j);
                            }
                        }
                    }
                    q.poll();
                }
            }
        }
        return c;
    }
}

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int adj[][]=new int[n][n];
        
        for(int row[]:adj) Arrays.fill(row,(int)1e9);
        for(int i=0;i<n;i++) adj[i][i]=0;
        
        for(int edge[]:edges){
            adj[edge[0]][edge[1]]=edge[2];
            adj[edge[1]][edge[0]]=edge[2];
        }

        //floyd warshall for all pair shortest paths
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    adj[i][j]=(int)Math.min(adj[i][j],adj[i][k]+adj[k][j]);
                }
            }
        }
        int mini=(int)1e9,cnt=0,ans=-1;
        for(int i=0;i<n;i++){
            cnt=0;
            for(int j=0;j<n;j++){
                if(adj[i][j]<=distanceThreshold && i!=j) cnt++;
            }
            if(cnt<=mini){
                mini=cnt;
                ans=i;
            }
        }
        return ans;
    }
}

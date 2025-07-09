class DisjointSet {
    int parent[], rank[], size[];
    public DisjointSet(int n) {
      parent = new int[n];
      for(int i=0;i<n;i++) parent[i]=i;

      rank = new int[n];
      Arrays.fill(rank,0);

      size = new int[n];
      Arrays.fill(size,1);
    }

    int findParent(int node){
        if(parent[node]==node) return node;
        return parent[node]=findParent(parent[node]);
    }

    public boolean find(int u, int v) {
        return (findParent(u)==findParent(v));
    }

    public boolean unionByRank(int u, int v) {

        int pu= findParent(u);
        int pv= findParent(v);
        if(pu==pv) return false;

        if(rank[pu]<rank[pv])
            parent[pu]=pv;
        else if( rank[pv] < rank[pu])
            parent[pv]=pu;
        else{
            parent[pu]=pv;
            rank[pv]++;
        }
        return true;
    }

    public void unionBySize(int u, int v) {
        int pu= findParent(u);
        int pv= findParent(v);
        if(pu==pv) return;

        if(size[pu] < size[pv])
            {
                parent[pu]=parent[pv];
                size[pv]+=size[pu];
            }
        else
            {
                parent[pv]=parent[pu];
                size[pu]+=size[pv];
            } 
    }
}



class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds =new DisjointSet(n);
        int spare=0, k=0;

        for(int connection[]: connections){
            int u=connection[0], v=connection[1];
            if(ds.unionByRank(u,v)==false) spare++;
        }

        for(int i=0;i<ds.parent.length;i++){
            if(ds.parent[i]==i) k++; //no of components
        }

        if(spare>=k-1) return k-1;
        return -1;

    }
}

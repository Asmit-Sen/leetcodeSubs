class Solution {
    // class dsu{
    //     int n;
    //     int par[];
    //     int size[];

    //     dsu(int n){
    //         par = new int[n];
    //         for(int i=0;i<n;i++) par[i]=i;

    //         size = new int[n];
    //         Arrays.fill(size,1);
    //     }

    //     int find(int u){
    //         if (u==par[u]) return u;
    //         return par[u] = find(par[u]);
    //     }

    //     boolean same(int u, int v){
    //         return find(u)==find(v);
    //     }

    //     void union(int u, int v){
    //         if (same(u,v)) return;

    //         int pu = find(u);
    //         int pv = find(v);

    //         if (size[pu]>=size[pv]){
    //             // add v to u
    //             par[pv]=pu;
    //             size[pu]+=size[pv];
    //         }
    //         else{
    //             // add u to v
    //             par[pu]=pv;
    //             size[pv]+=size[pu];
    //         }

    //     }
    // }
    void dfs(int i, int vis[], List<List<Integer>> adj){
        vis[i]=1;

        for(int nbr : adj.get(i)){
            if (vis[nbr]==0) dfs(nbr, vis, adj);
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        // all sus methods should be one isolaetd component

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        
        for(int edge[]:invocations){
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
        } 

        int sus[]=new int[n];

        dfs(k, sus, adj);

        boolean f=true;
        List<Integer> list = new ArrayList<>();

        for(int edge[] : invocations){
            int u = edge[0];
            int v = edge[1];
            
            if (sus[u]==0 && sus[v]==1) {
                f=false;
                break;
            }
        }

        for(int i=0;i<n;i++) {
            if (!f || sus[i]==0)
                list.add(i);
        }


        return list;
    }
}


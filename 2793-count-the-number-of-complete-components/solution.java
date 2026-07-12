class dsu{
    int par[];
    int size[];

    dsu(int n){
        par = new int[n];
        size = new int[n];

        for(int i=0;i<n;i++) par[i]=i;
        Arrays.fill(size,1);
    }

    int findpar(int u){
        if (par[u]==u) return u;
        return par[u]= findpar(par[u]);
    }

    boolean same(int u, int v){
        return findpar(u)==findpar(v);
    }

    void union(int u, int v){
        int pu = findpar(u);
        int pv = findpar(v);

        if (pu==pv) return;

        if (size[pu]<=size[pv]){
            par[pu] = par[pv];
            size[pv]+=size[pu];
        }
        else{
            par[pv] = par[pu];
            size[pu]+=size[pv];
        }
    }
}
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        dsu ds = new dsu(n);
        int degree[]=new int[n];

        for(int e[]:edges){
            ds.union(e[0], e[1]);
            degree[e[0]]++;
            degree[e[1]]++;
        }

        int leaders[]=new int[n];
        Arrays.fill(leaders,1);

        for(int i=0;i<n;i++){
            int par = ds.findpar(i);
            if (degree[i] == ds.size[par] - 1) continue;
            else leaders[par]=0;
        }

        int cnt=0;
        for(int i=0;i<n;i++){
            if (ds.par[i]==i) cnt += leaders[i];
        }

        return cnt;


    }
}

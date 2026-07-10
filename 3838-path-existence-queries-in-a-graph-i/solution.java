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
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        dsu ds = new dsu(n);

        for(int i=1;i<nums.length;i++){
            if (nums[i]-nums[i-1]<=maxDiff){
                // union
                ds.union(i, i-1);
            }
        }

        int l = queries.length;
        boolean res[] = new boolean[l];

        for(int i=0;i<l;i++){
            if (ds.same(queries[i][0], queries[i][1])) res[i]=true;
            else res[i]=false;
        }

        return res;
    }
}

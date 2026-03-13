import java.util.*;

class Solution {    
    class dsu {
        int parent[], size[];
        int components;
        dsu(int n) {
            parent = new int[n];
            size = new int[n];
            components = n;
            for(int i=0; i<n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int findParent(int node) {
            if (parent[node] == node) return node;
            return parent[node] = findParent(parent[node]);
        }

        boolean union(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);
            if (pu == pv) return false;
            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
            components--;
            return true;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {
        dsu ds = new dsu(n);
        List<Integer> list_opt = new ArrayList<>();
        int mini_must = Integer.MAX_VALUE;
        int must_count = 0;

        // 1. Process Must-Edges (Check for cycles immediately)
        for (int[] edge : edges) {
            if (edge[3] == 1) {
                if (!ds.union(edge[0], edge[1])) return -1; // Must-edge cycle
                mini_must = Math.min(mini_must, edge[2]);
                must_count++;
            }
        }

        // 2. Collect Optional Edges
        List<Integer> candidates = new ArrayList<>();
        for (int[] edge : edges) {
            if (edge[3] == 0) candidates.add(edge[2]);
        }
        
        // 3. Kruskal's for Optional Edges (Sort descending to maximize stability)
        // Note: For LC 3600 specifically, we need to sort the original edges
        List<int[]> optEdges = new ArrayList<>();
        for(int[] e : edges) if(e[3] == 0) optEdges.add(e);
        optEdges.sort((a, b) -> b[2] - a[2]);

        List<Integer> chosen = new ArrayList<>();
        for (int[] edge : optEdges) {
            if (ds.union(edge[0], edge[1])) {
                chosen.add(edge[2]);
            }
        }

        // 4. Final Connectivity Check
        if (ds.components != 1) return -1;

        // 5. Upgrade the 'k' smallest chosen edges to lift the bottleneck
        Collections.sort(chosen); 
        for (int i = 0; i < chosen.size() && i < k; i++) {
            chosen.set(i, chosen.get(i) * 2);
        }

        // Find new min of chosen edges after upgrades
        int mini_opt = Integer.MAX_VALUE;
        for (int val : chosen) mini_opt = Math.min(mini_opt, val);

        return Math.min(mini_must, mini_opt);
    }
}


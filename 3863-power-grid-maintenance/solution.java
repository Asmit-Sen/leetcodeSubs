import java.util.*;

class Solution {

    /**
     * Corrected DisjointSet Class
     * (Includes Path Compression, correct Union by Rank, and no static fields)
     */
    class DisjointSet {
        int ranks[], parent[];

        public DisjointSet(int n) {
            ranks = new int[n];
            parent = new int[n];

            Arrays.fill(ranks, 0);
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int findParent(int node) {
            if (parent[node] == node) return node;
            // Path Compression
            return parent[node] = findParent(parent[node]);
        }

        public void unionByRank(int u, int v) {
            int rootU = findParent(u);
            int rootV = findParent(v);

            if (rootU == rootV) return;

            int rankU = ranks[rootU];
            int rankV = ranks[rootV];

            if (rankU < rankV) {
                parent[rootU] = rootV;
            } else if (rankV < rankU) {
                parent[rootV] = rootU;
            } else {
                parent[rootV] = rootU;
                ranks[rootU]++;
            }
        }
    }

    /**
     * Optimized processQueries Method
     */
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        DisjointSet ds = new DisjointSet(c + 1);

        for (int conn[] : connections) {
            ds.unionByRank(conn[0], conn[1]);
        }

        // \U0001f6e0️ TLE FIX: This map stores a TreeSet of *ACTIVE* nodes for each component.
        Map<Integer, TreeSet<Integer>> activeNodesMap = new HashMap<>();

        // Populate the map. Initially, all nodes (0 to c) are active.
        for (int i = 0; i <= c; i++) {
            int root = ds.findParent(i);
            activeNodesMap.putIfAbsent(root, new TreeSet<>());
            activeNodesMap.get(root).add(i); // Add node 'i' to its component's active set
        }

        // We still need an isActive array for quick O(1) checks
        boolean isActive[] = new boolean[c + 1];
        Arrays.fill(isActive, true);

        List<Integer> list = new ArrayList<>();

        for (int q[] : queries) {
            int type = q[0];
            int node = q[1];

            if (type == 2) {
                // Deactivate node
                if (isActive[node]) { // Only process if it's currently active
                    isActive[node] = false;
                    int root = ds.findParent(node);
                    
                    // \U0001f6e0️ TLE FIX: Remove node from the active set
                    // This is an O(log c) operation
                    activeNodesMap.get(root).remove(node); 
                }
            } else { // type == 1
                if (isActive[node]) {
                    list.add(node); // O(1)
                } else {
                    // Node is inactive, find the smallest active node in its component
                    int root = ds.findParent(node); 
                    TreeSet<Integer> activeSet = activeNodesMap.get(root);

                    if (activeSet.isEmpty()) {
                        list.add(-1); // No active nodes in this component
                    } else {
                        // \U0001f6e0️ TLE FIX: Get the smallest element directly
                        // This is an O(1) or O(log c) operation
                        list.add(activeSet.first()); 
                    }
                }
            }
        }

        // Convert List<Integer> to int[]
        int n = list.size();
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}

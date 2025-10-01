import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {
        // A modulo constant for calculations
        long MOD = 1_000_000_007;

        // Adjacency list to store {neighbor, time}
        List<List<long[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];
            adj.get(u).add(new long[]{v, time});
            adj.get(v).add(new long[]{u, time});
        }

        // Priority queue to store {distance, node}
        // Using Long.compare for safe comparison of long values
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0, 0}); // {distance, node}

        // 'dist' array to store the shortest time from node 0
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        // 'ways' array to store the number of shortest paths
        long[] ways = new long[n];
        ways[0] = 1;

        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            long time = current[0];
            int node = (int) current[1];

            // If we found a longer path to the current node, skip it
            if (time > dist[node]) {
                continue;
            }

            for (long[] neighbor : adj.get(node)) {
                int adjNode = (int) neighbor[0];
                long edgeTime = neighbor[1];

                // If we found a new shorter path to the neighbor
                if (time + edgeTime < dist[adjNode]) {
                    dist[adjNode] = time + edgeTime;
                    ways[adjNode] = ways[node]; // Inherit the number of ways
                    pq.offer(new long[]{dist[adjNode], adjNode});
                } 
                // If we found another path of the same shortest length
                else if (time + edgeTime == dist[adjNode]) {
                    // Add the number of ways from the current path
                    ways[adjNode] = (ways[adjNode] + ways[node]) % MOD;
                }
            }
        }

        // Return the number of ways to reach the last node (n-1)
        return (int) (ways[n - 1] % MOD);
    }
}

class Pair {
    int i;
    int j;
    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public int orangesRotting(int[][] adj) {
        Queue<Pair> q = new LinkedList<>();
        int n = adj.length;
        int m = adj[0].length;

        int good = 0;
        int time = 0;

        // Step 1: Add all rotten oranges to the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (adj[i][j] == 2) {
                    q.offer(new Pair(i, j));
                }
                if (adj[i][j] == 1) good++; // fresh oranges
            }
        }

        int dx[] = {0, 0, -1, 1};
        int dy[] = {1, -1, 0, 0};

        while (!q.isEmpty()) {
            int size = q.size();
            boolean f = false;

            for (int l = 0; l < size; l++) {
                Pair rotten = q.poll();
                int i = rotten.i;
                int j = rotten.j;

                for (int dir = 0; dir < 4; dir++) {
                    int new_i = i + dx[dir];
                    int new_j = j + dy[dir];

                    if (new_i < 0 || new_i >= n || new_j < 0 || new_j >= m) continue;
                    if (adj[new_i][new_j] != 1) continue;

                    adj[new_i][new_j] = 2;
                    good--;
                    q.offer(new Pair(new_i, new_j));
                    f = true;
                }
            }

            if (f) time++;
        }

        return good == 0 ? time : -1;
    }
}


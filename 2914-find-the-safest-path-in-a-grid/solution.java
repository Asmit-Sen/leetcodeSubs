class Solution {
    boolean valid(int i, int j, int n){
        return i>=0 && j>=0 && i<n && j<n;
    }
    int f(int n, int manhatten[][]){
        int safety[][]=new int[n][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[2]-a[2]);
        safety[0][0] = manhatten[0][0];
        pq.offer(new int[]{0,0, safety[0][0]});

        int dx[]={0,0,-1,1};
        int dy[]={-1,1,0,0};

        while(!pq.isEmpty()){
            int top[]=pq.poll();
            int i=top[0], j=top[1], cur=top[2];

            for(int dir=0;dir<4;dir++){
                int ii = i + dx[dir];
                int jj = j + dy[dir];

                if (valid(ii, jj, n)){
                    int adjSafety = manhatten[ii][jj]; 
                    int newSafety = Math.min(cur, adjSafety);
                    if (newSafety > safety[ii][jj]){
                        safety[ii][jj] = newSafety;
                        pq.offer(new int[]{ii, jj, newSafety});
                    }

                }
            }
        }

        return safety[n-1][n-1];
    }
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        // maximise the minimum manhatten distance of the path from (0,0) to (n-1, n-1)

        int n = grid.size();
        int vis[][]=new int[n][n];

        int manhatten[][]=new int[n][n];
        for(int row[] : manhatten){
            Arrays.fill(row, (int)1e9);
        }

        Queue<int[]> manq = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if (grid.get(i).get(j)==1){
                    manhatten[i][j]=0;
                    manq.offer(new int[]{i,j,0});
                }
            }
        }

        int dx[]={0,0,-1,1};
        int dy[]={-1,1,0,0};

        while(!manq.isEmpty()){
            int top[]=manq.poll();
            int i = top[0];
            int j = top[1];
            int cur = top[2];

            for(int dir=0;dir<4;dir++){
                int ii = i + dx[dir];
                int jj = j + dy[dir];
                if (valid(ii,jj,n)){
                    if (cur+1<manhatten[ii][jj]){
                        manhatten[ii][jj]=cur+1;
                        manq.offer(new int[]{ii,jj, cur+1});
                    }
                }
            }
        }

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++)
        //         System.out.print(manhatten[i][j]+",");
        //     System.out.println();
        // }

        return f(n, manhatten);
    }
}

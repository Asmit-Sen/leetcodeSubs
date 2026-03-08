class Solution {
    boolean isValid(int i, int j, int n, int m){
        return (i>=0 && j>=0 && i<n && j<m);
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // cells that can be climbed onto from both sides of the ocean

        int n=heights.length, m=heights[0].length;

        int vis1[][]= new int[n][m];
        int vis2[][]= new int[n][m];

        int dx[]={0,0,1,-1};
        int dy[]={1,-1,0,0};

        Queue<int[]> q1 = new LinkedList<>();
        int r=0,c=0,nr=0,nc=0;

        for(int i=0;i<n;i++){
            q1.offer(new int[]{i,0});
            vis1[i][0]=1;
        } 
        for(int i=0;i<m;i++){
            q1.offer(new int[]{0,i});
            vis1[0][i]=1;
        } 

        while(!q1.isEmpty()){
            int top[]=q1.poll();
            r=top[0];
            c=top[1];

            for(int dir=0;dir<4;dir++){
                nr = r + dx[dir];
                nc = c + dy[dir];

                if (isValid(nr, nc, n, m) && vis1[nr][nc]==0 && heights[nr][nc]>=heights[r][c]){
                    vis1[nr][nc]=1;
                    q1.offer(new int[]{nr,nc});
                }
            }
        }

        r=0;
        c=0;
        nr=0;
        nc=0;
        Queue<int[]> q2 = new LinkedList<>();

        for(int i=0;i<n;i++){
            q2.offer(new int[]{i,m-1});
            vis2[i][m-1]=1;
        } 
        for(int i=0;i<m;i++){
            q2.offer(new int[]{n-1,i});
            vis2[n-1][i]=1;
        } 

        while(!q2.isEmpty()){
            int top1[]=q2.poll();
            r=top1[0];
            c=top1[1];

            for(int dir=0;dir<4;dir++){
                nr = r + dx[dir];
                nc = c + dy[dir];

                if (isValid(nr, nc, n, m) && vis2[nr][nc]==0 && heights[nr][nc]>=heights[r][c]){
                    vis2[nr][nc]=1;
                    q2.offer(new int[]{nr,nc});
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if (vis1[i][j]==1 && vis2[i][j]==1) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(j);
                    ans.add(pair);
                }
            }
        }

        return ans;
    }
}

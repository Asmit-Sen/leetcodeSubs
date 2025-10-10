class Solution {
    boolean isValid(int i, int j, int n, int m){
        return (i>=0 && j>=0 && i<n && j<m);
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;

        int vis1[][]=new int[n][m];
        int vis2[][]=new int[n][m];

        //floodfill from both the oceans
        //whcichever cell is both in vis1 and vis2 is part of ans

        List<List<Integer>> ans = new ArrayList<>();
        int dx[]={0,0,-1,1};
        int dy[]={1,-1,0,0};

        Queue<int[]> q1 = new LinkedList<>();
        for(int i=0;i<n;i++) q1.offer(new int[]{i,0});
        for(int i=0;i<m;i++) q1.offer(new int[]{0,i});

        while(!q1.isEmpty()){
            int top[], r, c;

            top = q1.poll();
            r=top[0];
            c=top[1];
            vis1[r][c]=1;

            for(int d=0;d<4;d++){
                int newr= r + dx[d];
                int newc= c + dy[d];
                if(isValid(newr, newc, n, m) && vis1[newr][newc]!=1  
                && heights[newr][newc]>=heights[r][c]){
                    q1.offer(new int[]{newr, newc});
                    
                }
            }
        }

        Queue<int[]> q2 = new LinkedList<>();
        for(int i=0;i<n;i++) q2.offer(new int[]{i,m-1});
        for(int i=0;i<m;i++) q2.offer(new int[]{n-1,i});

        while(!q2.isEmpty()){
            int top1[], r1, c1;

            top1= q2.poll();
            r1=top1[0];
            c1=top1[1];
            vis2[r1][c1]=1;

            for(int d=0;d<4;d++){
                int newr1= r1 + dx[d];
                int newc1= c1 + dy[d];
                if(isValid(newr1, newc1, n, m) && vis2[newr1][newc1]!=1  
                && heights[newr1][newc1]>=heights[r1][c1]){
                    q2.offer(new int[]{newr1, newc1});
                    
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis1[i][j]==1 && vis2[i][j]==1){   
                    List<Integer> pair= new ArrayList<>();
                    pair.add(i);
                    pair.add(j);
                    ans.add(pair);
                }
            }
        }
        return ans;
    }
}

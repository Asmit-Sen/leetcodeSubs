class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int top[]= new int[n+1];
        int down[]= new int[n+1];
        int left[]= new int[n+1];
        int right[]= new int[n+1];

        Arrays.fill(top, n+1);
        // Arrays.fill(down,Integer.MIN_VALUE);
        Arrays.fill(left,n+1);
        // Arrays.fill(right,Integer.MIN_VALUE);

        for(int building[] : buildings){
            int x=building[0], y=building[1];
            if (y<=top[x]) top[x]=y;
            if (y>=down[x]) down[x]=y;
            if (x<=left[y]) left[y]=x;
            if (x>=right[y]) right[y]=x;
        }

        // System.out.println("Top : ");
        // for(int x: top) System.out.print(x+",");
        // System.out.println();
        // System.out.println("Down :");
        // for(int x: down) System.out.print(x+",");
        // System.out.println();
        // System.out.println("Left :");
        // for(int x: left) System.out.print(x+",");
        // System.out.println();
        // System.out.println("Right :");
        // for(int x: right) System.out.print(x+",");

        int ans=0;
        for(int building[]:buildings){
            int x= building[0], y= building[1];
            if(x>left[y] && x<right[y] && y>top[x] && y<down[x]) {
                ans++;
            }
        }

        return ans;

    }
}

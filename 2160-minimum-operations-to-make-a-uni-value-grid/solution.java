class Solution {
    public int minOperations(int[][] grid, int x) {
        // the target value must be soewhere near the middle
        // 1,2,3,5
        // 1 0 1 3
        int n = grid.length, m = grid[0].length;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                list.add(grid[i][j]);
            }
        }
        Collections.sort(list);
        int target = list.get((int)list.size()/2);
        
        int c=0;
        for(int val : list){
            if ( Math.abs(target - val) % x != 0) return -1;
            c += Math.abs(target - val) / x;
        }
        return c;
    }
}

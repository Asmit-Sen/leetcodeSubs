class Solution {
    int f(int i, int items[][], int budget, int avail, int[] map, int dp[][][]){
        if (i==items.length) return 0;
        if (dp[i][budget][avail]!=-1) return dp[i][budget][avail];
        
        int take = 0, nottake = 0;
        
        if (items[i][1] <= budget){ 
            if (avail==1){
                take =  map[i] + 1 + 
                        f(i, items, budget - items[i][1], 0, map, dp);
            }
            else
                take = 1 + f(i, items, budget - items[i][1], 0, map, dp);
        }
        nottake = f(i+1, items, budget, 1, map, dp);
        
        return dp[i][budget][avail] = Math.max(take, nottake);
    }
    public int maximumSaleItems(int[][] items, int budget) {
        // pre compute buying an item i gives u what other items j - > n2
        int n = items.length;
        
        Arrays.sort(items, (a,b) -> a[0] - b[0]);
        int map[] = new int[n];
        // Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i=0;i<n;i++){
            int fac = items[i][0];
            for(int j=0;j<n;j++){
                if (j!=i && (items[j][0] % fac)==0){
                    // item[i] -> append item[j]
                    map[i]++;
                } 
            }    
        }

        // for(int i=0;i<n;i++) {
        //     System.out.println(i + "->" + map[i]);
        // }


        // f(ind, spent, items, budget, map) -> max no if unique items
        int dp[][][] = new int[n+1][budget+1][2];
        for(int col[][] : dp){
            for(int row[]: col){
                Arrays.fill(row, -1);
            }
        }
        
        return f(0, items, budget, 1, map, dp);
    }
}

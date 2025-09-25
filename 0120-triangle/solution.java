class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.get(triangle.size()-1).size();
        // int prev[]=new int[n];
        int curr[]=new int[n];

        for(int i=0;i<n;i++)
        curr[i]=triangle.get(n-1).get(i);

        for(int i=n-2;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                curr[j]=(int)Math.min(curr[j],curr[j+1])+triangle.get(i).get(j);
            }
        }
        
        return curr[0];
    }
}

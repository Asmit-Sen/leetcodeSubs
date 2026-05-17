class Solution {
    boolean dfs (int i, int arr[], int vis[]){
        vis[i]=1;
        if (arr[i]==0) return true;

        boolean x = false, y = false;
        if (i + arr[i] < arr.length && vis[i+arr[i]]==0) x = dfs(i+arr[i], arr, vis);
        if (i - arr[i] >= 0 && vis[i-arr[i]]==0) y = dfs(i-arr[i], arr, vis);

        return x | y;
    }
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        int vis[] = new int[n];
        
        return dfs(start, arr, vis);
    }
}

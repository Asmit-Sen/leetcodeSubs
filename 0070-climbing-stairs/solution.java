class Solution {
    int stairs(int n, int arr[])
    {
        if(n<=1) return 1;
        if (arr[n]!=-1) return arr[n];
        return(arr[n]=stairs(n-1,arr)+stairs(n-2,arr));
    }
    public int climbStairs(int n) {

        int arr[]=new int[n+1];
        for(int i=0;i<arr.length;i++)
        arr[i]=-1;
        return stairs(n,arr);
        
    }
}

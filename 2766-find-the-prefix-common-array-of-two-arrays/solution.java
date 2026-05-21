class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        // HashMap<Integer, Integer> map = new HashMap<>();
        int c = 0;
        int n = A.length;
        int ans[]=new int[n];


        int f[]=new int[51];

        for(int i=0;i<n;i++){
            f[A[i]]++;
            if (f[A[i]]==0) c++;
            f[B[i]]--;
            if (f[B[i]]==0) c++;

            ans[i]=c;
        }
        return ans;
    }
}

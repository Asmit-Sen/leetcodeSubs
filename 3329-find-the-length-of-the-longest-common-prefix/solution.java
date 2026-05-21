class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for(int x : arr1){
            int n = (int)Math.floor(Math.log10(x));
            while(n>=0){
                int pre = x / (int)Math.pow(10, n--);
                set.add(pre);
            }
        }
        
        int ans = 0;
        for(int x : arr2){
            int n2 = (int)Math.floor(Math.log10(x));
            while(n2>=0){
                int pre2 = x / (int)Math.pow(10, n2--);
                if (set.contains(pre2)) ans = (int)Math.max(ans, Math.floor((int)Math.log10(pre2))+1);
            }
        }
        return ans;
        
    }
}

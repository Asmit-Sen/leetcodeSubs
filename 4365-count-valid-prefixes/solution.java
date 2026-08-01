class Solution {
    public int countValidPrefixes(String s) {
        int n = s.length();
        int pre[]=new int[n];

        pre[0]=s.charAt(0)=='0'? 0 : 1;
        for(int i=1;i<n;i++) pre[i] = pre[i-1] + (s.charAt(i)-'0');

        // for(int x : pre) System.out.println(x);

        int ans=0;
        for(int i=0;i<n;i++){
            int z = i - pre[i] + 1;
            if (Math.abs(pre[i]-z)<=1) ans++;
        }
        return ans;
    }
}

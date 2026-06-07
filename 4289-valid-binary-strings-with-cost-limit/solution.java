class Solution {
    void f (int i, int n, int k, StringBuilder st, List<String> list){
        if (k<0) return;
        if (i==n) {
            list.add(st.toString());
            return;
        }

        // take a 0
        StringBuilder str = new StringBuilder(st);
        str.append('0');
        f(i+1, n, k, str, list);

        // take a 1 if allows
        if (i==0 || (k>=i && st.charAt(st.length()-1)!='1')){
            StringBuilder str1 = new StringBuilder(st);
            str1.append('1');
            f(i+1, n, k-i, str1, list);
        }
        
    }
    public List<String> generateValidStrings(int n, int k) {
        List<String> list = new ArrayList<>();

        f(0, n, k, new StringBuilder(""), list);
        return list;
    }
}

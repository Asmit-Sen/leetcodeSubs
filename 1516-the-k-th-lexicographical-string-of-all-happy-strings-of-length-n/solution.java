class Solution {
    void f(String w, List<String> list, int nn){
        if (w.length() == nn){
            list.add(w);
            return;
        }
        int n = w.length();
        if (n==0 || w.charAt(n-1)!='a') f(w+'a', list, nn);
        if (n==0 || w.charAt(n-1)!='b') f(w+'b', list, nn);
        if (n==0 || w.charAt(n-1)!='c') f(w+'c', list, nn);
    }
    public String getHappyString(int n, int k) {
        List<String> list = new ArrayList<>();
        f("", list, n);
        Collections.sort(list);
        return list.size()<k ? "" : list.get(k-1);
    }
}

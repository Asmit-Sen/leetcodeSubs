class Solution {
    void f(String s, int n, int l,int r, List<String> ans)
    {
        if(s.length()==n*2)
        {
            ans.add(s);
            return;
        }
        if(l<n) 
        f(s+"(",n,l+1,r,ans);
        if(r<l)
        f(s+")",n,l,r+1,ans);
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        f("",n,0,0,ans);
        return ans;
    }
}

class Solution {
    void f(int k,int n,int cnt, List<Integer> list, List<List<Integer>> ans )
    {
        if(n==0 && k==0)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(k<0) return;

        for(int i=cnt;i<10;i++)
        {
            list.add(i);
            f(k-1,n-i,i+1,list,ans);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        f(k,n,1,new ArrayList<>(), ans);
        return ans;
    }
}

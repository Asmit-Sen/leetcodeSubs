class Solution {
    void f(int digit, int k, int n, List<Integer> list, List<List<Integer>> ans)
    {
        if(digit==10)
        {
            if(k==0 && n==0)
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(digit);
        f(digit+1,k-1,n-digit,list,ans);//take the digit
        list.remove(list.size()-1);
        f(digit+1,k,n,list,ans);//dont take the digit

    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        f(1,k,n,new ArrayList<>(),ans);
        return ans;
    }
}

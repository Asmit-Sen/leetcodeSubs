class Solution {
    void sum( int k, int target, int idx, int sum, List<Integer> list, List<List<Integer>> ans)
    {
        if(list.size()==k)
        {
            if(sum==target)
                ans.add(new ArrayList<>(list));
            return;
        }
        if(idx>9 || sum>target)
        return;
        //pick current idx
        list.add(idx);
        sum+=idx;
        sum(k,target,idx+1, sum,list, ans);

        //not pick idx
        sum-=idx;
        list.remove(list.size()-1);
        sum(k,target,idx+1, sum, list, ans);

    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        sum(k,n,1,0,new ArrayList<>(), ans);
        return ans;
    }
}

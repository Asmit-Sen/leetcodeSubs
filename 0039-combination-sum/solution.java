class Solution {
    void sum(int i,int []arr, int sum, int target, List<Integer> sub, List<List<Integer>> ans)
    {
        //base
        if(sum>target) return;
        if(sum==target)
            {
                ans.add(new ArrayList<>(sub));
                return;
            }
        if(i>=arr.length)
        return;

        sum+=arr[i];
        sub.add(arr[i]);
        //take
        sum(i,arr,sum,target,sub,ans);

        sum-=arr[i];
        sub.remove(sub.size()-1);
        //not take
        sum(i+1,arr,sum,target,sub,ans);


    }
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List <Integer> sub =new ArrayList<>();
        List <List<Integer>> ans=new ArrayList<List<Integer>>();
        sum(0,arr,0,target,sub,ans);
        return ans;
        
    }
}

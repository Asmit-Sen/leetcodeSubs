class Solution {
    void sum(int i,int []arr, int sum, int target, List<Integer> sub, List<List<Integer>> ans)
    {
        //base
        if(sum>target) return;
        if(sum==target)
            {
                if(!ans.contains(sub))ans.add(new ArrayList<>(sub));
                return;
            }
        for(int j=i;j<arr.length;j++)
        {
            
            if(j>i && arr[j]==arr[j-1]) continue;
            if(arr[j]>target) break;

            sum+=arr[j];
            sub.add(arr[j]);
            //take
            sum(j+1,arr,sum,target,sub,ans);

            sum-=arr[j];
            sub.remove(sub.size()-1);
        }        
        


    }
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List <Integer> sub =new ArrayList<>();
        List <List<Integer>> ans=new ArrayList<List<Integer>>();
        Arrays.sort(arr);
        sum(0,arr,0,target,sub,ans);
        return ans;
        
    }
}

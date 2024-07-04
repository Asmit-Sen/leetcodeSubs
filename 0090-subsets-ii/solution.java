class Solution {
    void subsets(int arr[],int idx, List<Integer> list, List<List<Integer>> ans)
    {
        ans.add(new ArrayList<>(list));
        for(int i=idx;i<arr.length;i++)
        {
            if(i>idx && arr[i]==arr[i-1]) continue;
            list.add(arr[i]);
            subsets(arr, i+1, list, ans);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans= new ArrayList<List<Integer>>();
        subsets(arr,0,new ArrayList<>(), ans);
        return ans;

    }
}

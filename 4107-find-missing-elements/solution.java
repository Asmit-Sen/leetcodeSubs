class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        // int f[]=new int[101];
        BitSet mask = new BitSet();

        int mini = 101, maxi = 0;
        for(int x:nums){
            mini = Math.min(mini, x);
            maxi = Math.max(maxi, x);

            // f[x]=1;
            mask.set(x);
        }

        for(int i=mini;i<=maxi;i++){
            // if (f[i]==0) list.add(i);
            if (!mask.get(i)) list.add(i);
        }
        return list;
    }
}

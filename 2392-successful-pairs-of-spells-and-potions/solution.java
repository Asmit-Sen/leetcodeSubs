class Solution {
    int f(long spell, int potions[], long success){
        int low=0, high= potions.length-1;
        int ans=potions.length;
        while(low<=high){
            int mid=(low+high)/2;
            long prod=potions[mid]*spell;
            if(prod>=success){
                ans=mid;
                high=mid-1;
            }
            else
            low=mid+1;
        }
        return potions.length-ans;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int n=potions.length, p=0;
        int ans[]=new int[spells.length];
        
        for(int spell : spells){
            ans[p++]=f(spell, potions, success);
        }

        return ans;
    }
}

class Solution {
    int count(int target, int low, int high){
        int ans=0;
        while(low<high){
            if(low*low+high*high==target) {
                ans+=2;
                low++;
                high--;
            }
            else if(low*low+high*high<target){
                low++;
            }
            else high--;
        }
        return ans;
    }
    public int countTriples(int n) {
        int ans=0;
        for(int i=n; i>=1; i--){
            int c=i;
            ans+=count(c*c, 1, c-1);
        }
        return ans;
    }
}

class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int xor = 0, n = nums.length - 2 ;
        for(int x: nums){
            xor ^= x;
        }
        for(int i=0;i<n;i++)  
        xor^=i;
        
        int diff= xor & -xor;
        int a=0, b=0;
        for(int x: nums){
            if((x & diff)!=0) a^=x;
            else b ^= x;
        }
        for(int i=0;i<n;i++){
            if((i & diff)!=0) a^=i;
            else b ^= i;
        }
        return new int[]{a,b};
    }
}

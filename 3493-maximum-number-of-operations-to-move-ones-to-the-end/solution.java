class Solution {
    public int maxOperations(String nums) {
        // start to shift the ones from the left to increase collisions 
        // 1001101
        // 1112334 = prefix
        // 2001100 = 4 operations

        // 100100010
        // 111222233
        // 300200010

        // if nums[i]==1 && prefix[i+1]==prefix[i]
        // there is atleast one 0 after this 1
        // that means atleast one shift occurs from left to right


        int ans=0;
        int n=nums.length();

        // int prefix[]=new int[n];
        // prefix[0] = (nums.charAt(0)-'0');
        
        // for(int i=1;i<n;i++){
        //     prefix[i] = (nums.charAt(i)-'0') + prefix[i-1];
        // }

        // int moves[] = new int[n];
        // for(int i=0;i<n-1;i++){
        //     if(nums.charAt(i)=='1' && prefix[i]==prefix[i+1])
        //     moves[i]=1;
        // }

        int prev=0;
        boolean f=false;
        for(int i=n-1;i>=0;i--){
            if(nums.charAt(i) == '0') f=true;
            if (nums.charAt(i) == '1') {
                prev+=f?1:0;
                ans+=prev;
                f=false;
            }
        }

        return ans;
    }
}

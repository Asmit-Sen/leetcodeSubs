class Solution {
    public int maximumLength(int[] nums) {

        if(nums.length<3) return nums.length;

        int even=0, odd=0, prev=0, cnt=1;
        for(int i=0;i<nums.length;i++){
            nums[i]%=2;
            if(nums[i]==1) odd++;
            else even++;
        }

        for(int i=1;i<nums.length;i++){
            if((nums[i]^nums[prev])==1){
                prev=i;
                cnt++;
            }
        }

        return (int)Math.max(even, (int)Math.max(odd,cnt));
    }
}

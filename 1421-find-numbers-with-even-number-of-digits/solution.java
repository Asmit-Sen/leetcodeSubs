class Solution {
    int digits(int num){
        return num==0?0:1+digits(num/10);
    }
    public int findNumbers(int[] nums) {
        int c=0;
        for(int num:nums){
            if(digits(num)%2==0) c++;
        }
        return c;
    }
}

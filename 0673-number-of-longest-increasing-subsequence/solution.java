class Solution {
    public int findNumberOfLIS(int[] nums) {

        int n=nums.length;
        int lis[]=new int[n];
        Arrays.fill(lis,1);

        int hash[]=new int[n];
        Arrays.fill(hash,1);

        int maxi=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    // if a new element is added to the lis, then hash[current_index]=hash[prev_index] 
                    //(as the new element is attached to the sequence)
                    if(lis[j]+1>lis[i]){
                        lis[i]=lis[j]+1;
                        hash[i]=hash[j];
                    }
                    // if some previous elements, on addition of the current index, 
                    // give the same LIS value then we have multiple LIS ending at the current index
                    // so add hash[prev_index] to the has[curr_index]
                    else if(lis[j]+1==lis[i])
                    hash[i]+=hash[j];
                }
            }
            maxi=(int)Math.max(maxi,lis[i]);
        }

        int total=0;
        for(int i=0;i<n;i++) 
        if(lis[i]==maxi) total+=hash[i];
        
        return total;
        
    }
}

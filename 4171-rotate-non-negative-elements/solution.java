class Solution {
    int[] rotate(int[] arr, int k){
        int n=arr.length;
        if (n==0) return new int[]{};
        k = k % n;

        // 1 2 3 4 5 
        // k = 3
        // last (n - k) ele
        // first k ele
        // 4 5 1 2 3

        int temp[] = new int[n];
        int p = 0;
        for(int i=k;i<n;i++){
            temp[p++]=arr[i];
        }
        for(int i=0;i<k;i++){
            temp[p++]=arr[i];
        }

        return temp;
    }
    public int[] rotateElements(int[] nums, int k) {
        int c=0;
        for(int x: nums) if (x>=0) c++;

        int temp[] = new int[c];
        int p=0;
        for(int x:nums) if(x>=0) temp[p++]=x;
        
        int arr[] = rotate(temp, k);

        int n=nums.length;
        int pos=0;
        for(int i=0;i<n;i++){
            if(nums[i]<0) continue;
            nums[i]=arr[pos++];
        }
        
        return nums;
    }
}

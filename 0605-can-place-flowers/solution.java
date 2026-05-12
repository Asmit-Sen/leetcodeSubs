class Solution {
    public boolean canPlaceFlowers(int[] arr, int k) {
        if (arr.length==1) return (k==0 || (k==1 && arr[0]==0));
        if (arr.length==2) return (k==0 || (k==1 && arr[0]==0 && arr[1]==0));
        int cnt=0, n=arr.length;
        
        if (arr[0]==0 && arr[1]==0) {
            cnt++;
            arr[0]=1;
        }
        if (arr[n-1]==0 && arr[n-2]==0) {
            cnt++;
            arr[n-1]=1;
        }

        for(int i = 1; i<n-1; i++){
            if (arr[i]==0 && arr[i-1]==0 && arr[i+1]==0) {
                cnt++;
                arr[i]=1;
            }
        }

        return cnt>=k;
    }
}

class Solution {
    public boolean isPowerOfTwo(int n) {
        int low=(int)-2e31;
        int high=(int)2e31-1;

        // while(low<=high){
        //     int mid=low+(high-low)/2;
        //     int val=(int)Math.pow(2,mid);
        //     if(val==n) return true;
        //     else if(n<val) high=mid-1;
        //     else low=mid+1;
        // }
        // return false;

        // float val=(float)(Math.log(n)/Math.log(2.0));
        // System.out.println(val);
        // if(val==(int)val) return true;
        // return false;
        if(n<=0) return false;
        return ((n&(n-1))==0)?true:false;
    }
}

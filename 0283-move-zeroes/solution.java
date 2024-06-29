class Solution {
    public void moveZeroes(int[] arr) {
        int pos=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]!=0) arr[pos++]=arr[i];// since we have zeroes at the end, we can overwrite the non zero ele starting from the first
        }        
        for(int i=pos;i<arr.length;i++)
        arr[i]=0;
    }
}

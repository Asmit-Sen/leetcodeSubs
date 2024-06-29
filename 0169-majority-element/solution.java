class Solution {
    public int majorityElement(int[] arr) {

         int c=0,el=-1;
         for(int i=0;i<arr.length;i++)
         {
            if(c==0) el=arr[i];
            if(arr[i]==el) c++;
            else c--;
         }       
         int cnt=0;
         for(int num:arr)
         if(num==el) cnt++;
         if(cnt>(arr.length/2)) return el;
         else return -1;
    }
}

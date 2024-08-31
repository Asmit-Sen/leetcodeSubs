class Solution {
    public int removeDuplicates(int[] arr) {

        if(arr.length<=2) return arr.length;
        int pos=2; // all unique pairs should start from index 2 as we allow a max of 2 duplicates

        for(int i=2;i<arr.length;i++)
        {
            if(arr[i]!=arr[pos-2])
            {
                arr[pos]=arr[i];
                pos++;
            }
        }
        return pos;
    }
}

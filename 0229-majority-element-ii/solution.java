class Solution {
    public List<Integer> majorityElement(int[] arr) {
        List <Integer> list=new ArrayList<>();
        int el1=Integer.MIN_VALUE,el2=Integer.MIN_VALUE,c1=0,c2=0;

        for(int i=0;i<arr.length;i++)
        {
            if(c1==0 && arr[i]!=el2) el1=arr[i];
            if(c2==0 && arr[i]!=el1) el2=arr[i];
            if(arr[i]==el1) c1++;
            else if(arr[i]==el2) c2++;
            else
            {
                c1--;
                c2--;
            }
        }
        c1=0;
        c2=0;
        for(int num:arr)
        {
            if(num==el1) c1++;
            if(num==el2) c2++;
        }
        int n=arr.length;
        if(c1>n/3) list.add(el1);
        if(c2>n/3) list.add(el2);
        return list;
    }
}

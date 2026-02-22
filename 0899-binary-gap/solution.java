class Solution {
    public int binaryGap(int num) {
        //  1000001001
        //  1111112223

        // int arr[] = convert(n);
        List<Integer> list = new ArrayList<>();
        while(num!=0){
            if ((num&1)!=0){
                list.add(1);
            }
            else list.add(0);
            num=num>>1;
        }

        int n=list.size();

        // int pre[]=new int [n];
        // pre[n-1]=list.get(n-1);

        // for(int i=n-2;i>=0;i--){
        //     pre[i]=pre[i+1]+list.get(i);
        // }

        int ans=0, prev=-1;
        for(int i=n-1;i>=0;i--){
            if (list.get(i)==1){
                if (prev!=-1){
                    ans=(int)Math.max(ans, prev-i);
                }
                prev=i;
            }
        }
        return ans;
    }
}

class Solution {
    public int maximum69Number (int num) {
        char arr[]=Integer.toString(num).toCharArray();

        for(int i=0;i<arr.length;i++){
            if(arr[i]=='6') {
                arr[i]='9';
                break;
            }
        }

        int p=arr.length-1;
        int i=0, ans=0;
        while(p>=0){
            ans+=(int)Math.pow(10,p--)*(arr[i++]-'0');
        }       
        return ans;

    }
}

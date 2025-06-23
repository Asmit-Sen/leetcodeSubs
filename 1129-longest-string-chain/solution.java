class Solution {
    boolean valid(char c1[], char c2[]){
        if(c2.length!=c1.length+1) return false;

        int i=0, j=0, flag=0;
        while(i<c1.length && j<c2.length){
            if(c1[i]==c2[j]) {
                i++;
                j++;
            }
            else{
                if(flag==1) return false;
                j++;
                flag=1;
            }
        }
        return true;
    }
    public int longestStrChain(String[] words) {
        int maxi=0;
        int n=words.length;
        int lis[]=new int[n];

        Arrays.fill(lis,1);
        Arrays.sort(words, (a,b)->a.length() - b.length());

        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(valid(words[prev].toCharArray(),words[i].toCharArray())) {
                    lis[i]=(int)Math.max(lis[i],lis[prev]+1);
                }
            }
            maxi=(int)Math.max(maxi,lis[i]);
        }
    return maxi;
    }
}

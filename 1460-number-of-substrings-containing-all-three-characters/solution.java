class Solution {
    int min_num(int a, int b, int c)
        {
            int x=(int)Math.min(a,b);
            int y=(int)Math.min(x,c);
            return y;
        }
    public int numberOfSubstrings(String s) {
        //better - O(2N)
        // int arr[]=new int[3];
        // for(int i=0;i<arr.length;i++)
        // arr[i]=0;

        // int l=0,r=0,cnt=0;
        // int n=s.length();
        // char ch;
        
        // while(l<=r && r<s.length())
        // {
        //     ch=s.charAt(r);
        //     arr[ch-'a']++;
            
        //     while(arr[0]+arr[1]+arr[2]>=3) 
        //     {
        //         if( arr[0]==0 || arr[1]==0 || arr[2]==0 ) break; 
        //         cnt+=n-r;
        //         ch=s.charAt(l);
        //         arr[ch-'a']--;
        //         l++;
        //     }
        //     r++;
        // }
        // return cnt;
        

        //optimal O(N)

        

        int arr[]={-1,-1,-1};
        int cnt=0;

        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            arr[ch-'a']=i;
            cnt+=min_num(arr[0],arr[1],arr[2])+1;
        }
        return cnt;

    }
}

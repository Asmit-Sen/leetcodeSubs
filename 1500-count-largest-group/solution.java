class Solution {
    int sum(int n){
        return (n==0)?0:(n%10+sum(n/10));
    }
    public int countLargestGroup(int n) {
        int map[]=new int[37];

        for(int i=1;i<=n;i++)
        map[sum(i)]++;

        int maxi=0,cnt=1;
        for(int x:map){
            if(x>maxi) {
                maxi=x;
                cnt=1;
            }
            else if(x==maxi){
                cnt++;
            }
        }
        return cnt;
    }
}

class Solution {
    public int numberOfWays(String corridor) {
        int mod=(int)1e9+7;

        int n = corridor.length(), p=0;
        int arr[]=new int[n];

        arr[0] = (corridor.charAt(0)=='S')?1:0;
        for(int i=1;i<n;i++){
            if(corridor.charAt(i) == 'S') arr[i] = arr[i-1]+1;
            else arr[i]=arr[i-1];
        }

        // for(int x:arr) System.out.print(x+",");
        Map<Integer,Integer> map= new HashMap<>();

        for(int x:arr){
            if(x!=0 && x%2==0){
                map.put(x, map.getOrDefault(x,0)+1);
            }
        }

        long ans=1;
        for(int key:map.keySet())
            if (key!=arr[n-1]) ans = ((long) ans * map.get(key)) % mod;

        if(arr[n-1]<2 || arr[n-1]%2==1) return 0;
        if(arr[n-1]==2) return 1;
        return (int)ans;

    }
}

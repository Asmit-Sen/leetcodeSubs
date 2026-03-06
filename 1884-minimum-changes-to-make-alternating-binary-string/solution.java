class Solution {
    public int minOperations(String s) {
        int starts_with_1 = 0, starts_with_0 = 0;
        char str[]=s.toCharArray();

        // 1010.... or 0101....
        for(int i=0;i<str.length;i++){
            if (str[i]=='0' && (i%2!=0) || str[i]=='1' && (i%2==0)) starts_with_1++;
            if (str[i]=='0' && (i%2==0) || str[i]=='1' && (i%2!=0)) starts_with_0++;
        }

        System.out.println(starts_with_0);
        System.out.println(starts_with_1);

        return (int)Math.min(starts_with_0, starts_with_1);
        
    }
}

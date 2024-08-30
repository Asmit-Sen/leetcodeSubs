class Solution {
    boolean almostEqual(int num1, int num2)
    {
        String a=Integer.toString(num1);
        String b=Integer.toString(num2);
        int l1=a.length(), l2=b.length();
        // make them of equal length;
        int max=(int)Math.max(l1,l2);

        while(l1!=max)
        {
            a="0"+a;
            l1++;
        }

        while(l2!=max)
        {
            b="0"+b;
            l2++;
        }
        int cnt=0;
        int hash1[]=new int[10], hash2[]=new int[10];
        for(int i=0;i<max;i++)
        {
            cnt+=(((a.charAt(i)-'0')^(b.charAt(i)-'0'))!=0)?1:0;
            hash1[a.charAt(i)-'0']++;
            hash2[b.charAt(i)-'0']++;
        }
        System.out.println(a+" "+b+" "+cnt);

        for(int i=0;i<10;i++)
        {
            if(hash1[i]!=hash2[i])
            return false;
        }
        return (cnt<=2);
    }
    public int countPairs(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                count+=(almostEqual(nums[i],nums[j])==true)?1:0;
            }
        }
        return count;
    }
}

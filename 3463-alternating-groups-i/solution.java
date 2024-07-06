class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int c=0,n=colors.length;
        if(n<3) return 0;
        for(int i=1;i<colors.length-1;i++)
        {
            if(colors[i-1]!=colors[i] && colors[i+1]!=colors[i])
            c++;
        }
      
            if(colors[0]!=colors[1] && colors[0]!=colors[n-1]) c++;
            if(colors[n-1]!=colors[n-2] && colors[n-1]!=colors[0]) c++;

        
        return c;
    }
}

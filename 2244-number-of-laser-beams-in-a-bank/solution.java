class Solution {
    public int numberOfBeams(String[] bank) {
        // int n= bank[0].length;
        int n=bank.length;
        int laser[]=new int[n];
        int p=0;
        for(String row : bank){
            int c=0;
            // System.out.println ("Row : " + row);
            for(char cell: row.toCharArray()) {
                if(cell == '1') c++;
            }
            // System.out.println ("count : " + c);
            laser[p++]=c;
        }

        int prev=0, ans=0;
        for(int i=0;i<laser.length;i++){
            if(laser[i]!=0){
                ans+=laser[i]*prev;
                prev=laser[i];
            }
        }

        // for(int x: laser) System.out.print(x);

        return ans;
    }
}

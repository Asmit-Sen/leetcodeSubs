class Solution {
    public String[] createGrid(int n, int m) {
        String ans[] = new String[n];
        for(int i=0;i<n;i++){
            String row = "";
            if (i==0) 
                for(int j=0;j<m;j++) row += '.';
            else{
                for(int j=0;j<m-1;j++) row += '#';
                row+='.';
            }
            ans[i] = row;
        }
        return ans;
    }
}

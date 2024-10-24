class Solution {
    boolean f(char [][]board, String target, int idx, int r, int c, int m, int n)
    {
        if(idx==target.length())
        return true;
        //we found a wor after matching every index char by char

        if( r<0 || r==m || c<0 || c==n || board[r][c]!=target.charAt(idx) || board[r][c]=='?')
        return false;

        
        char ch=board[r][c];
        board [r][c]='?';
        boolean left=false, right=false, up=false, down=false;
        
        
        left=f(board,target,idx+1,r,c-1,m,n);
        
        right=f(board,target,idx+1,r,c+1,m,n);
        
        up=f(board,target,idx+1,r-1,c,m,n);
        
        down=f(board,target,idx+1,r+1,c,m,n);

        board[r][c]=ch;
        return (left || right || up || down);
    }
    public boolean exist(char[][] board, String word) {
        int m= board.length;
        int n=board[0].length;
        int vis[][]=new int[m][n];

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    if (f(board,word,0,i,j,m,n))
                    return true; 
                }
            }
        }
        return false;
    }
}

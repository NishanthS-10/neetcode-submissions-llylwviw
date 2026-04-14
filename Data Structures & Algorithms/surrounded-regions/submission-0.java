class Solution {
    public void solve(char[][] board) {
         int m=board.length;
         int n=board[0].length;
         for(int i=0;i<m;i++){
              if(board[i][0]=='O')
                  dfs(board,i,0,m,n);
              if(board[i][n-1]=='O')
                   dfs(board,i,n-1,m,n);
         }
         for(int j=0;j<n;j++){
               if(board[0][j]=='O')
                    dfs(board,0,j,m,n);
                if(board[m-1][j]=='O')
                    dfs(board,m-1,j,m,n);
         }

         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                 if(board[i][j]=='T')
                     board[i][j]='O';
                 else if(board[i][j]=='O')
                     board[i][j]='X';
            }
         }
    }

    public void dfs(char b[][],int r,int c,int m, int n){
         if(r>=m || c>=n || r<0 || c<0 || b[r][c]!='O') return;
         b[r][c]='T';
         dfs(b,r,c+1,m,n);
         dfs(b,r+1,c,m,n);
         dfs(b,r,c-1,m,n);
         dfs(b,r-1,c,m,n);
    }
}

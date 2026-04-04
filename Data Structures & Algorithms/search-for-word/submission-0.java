class Solution {
    int R;
    int C;
    public boolean exist(char[][] board, String word) {
          R=board.length;
          C=board[0].length;
          for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(exist(board,word,i,j,0))
                    return true;
            }
          }
          return false;
    }
    public boolean exist(char[][] b,String word,int i,int j,int a){
        if(a==word.length()){
            return true;
        }
        if(i>=R || j>=C || i<0 || j<0 || b[i][j]!=word.charAt(a)){
            return false;
        }
        b[i][j]='#';
        boolean res=exist(b,word,i-1,j,a+1) || exist(b,word,i+1,j,a+1)||exist(b,word,i,j-1,a+1)||exist(b,word,i,j+1,a+1);
        b[i][j]=word.charAt(a);
        return res;
    }
}

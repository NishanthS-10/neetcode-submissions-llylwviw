class Solution {
    public int orangesRotting(int[][] g) {
         int m=g.length;
         int n=g[0].length;
          int dir[][]={{0,1},{1,0},{-1,0},{0,-1}};
          int leftover=0;
         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(g[i][j] ==1){
                     leftover++;
                }
            }
         }
         int time=0;
         while(leftover>0){
            boolean flag=false;
         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                 if(g[i][j]==2){
                 for(int d[]:dir){
                   int x=i+d[0];
                    int y=j+d[1];
                 if(x>=m || y>=n || x<0 || y<0  || g[x][y]==2 || g[x][y]==0 || g[x][y]==3)
                     continue;
                    if(g[x][y]==1){
                        leftover--;
                        g[x][y]=3;
                        flag=true;
                    } 
                  }
                 }
            }
         }
         if(!flag) return -1;
         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                 if(g[i][j]==3) g[i][j]=2;
            }
         }
           time++;
         }
         return time;
    }
   
}

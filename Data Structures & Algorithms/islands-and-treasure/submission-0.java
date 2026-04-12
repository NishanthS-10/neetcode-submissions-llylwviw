class Solution {
    public void islandsAndTreasure(int[][] grid) {
         int m=grid.length;
         int n=grid[0].length;
         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] !=-1 && grid[i][j]!=0){
                      bfs(grid,i,j,m,n);
                }
            }
         }
    }
    public void bfs(int[][] g,int i,int j, int m, int n){
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{i,j,0});
        boolean v[][]=new boolean[m][n];
        int dir[][]={{0,1},{1,0},{-1,0},{0,-1}};
        v[i][j]=true;
        while(!q.isEmpty()){
              int arr[]=q.poll();
              int a=arr[0];
              int b=arr[1];
              int c=arr[2];
             for(int d[]:dir){
                int x=a+d[0];
                int y=b+d[1];
                if(x>=m || y>=n || x<0 || y<0 || v[x][y] || g[x][y]==-1)
                     continue;
                if(g[x][y]==0){
                    g[i][j]=Math.min(g[i][j],c+1);
                }
                q.offer(new int[]{x,y,c+1});
                v[x][y]=true;
             }
        }     
    }
}

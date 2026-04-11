class Solution {
    public int numIslands(char[][] grid) {
         int m=grid.length;
         int n=grid[0].length;
         int count=0;
         for(int i=0;i<m;i++){
              for(int j=0;j<n;j++){
                  if(grid[i][j]=='1'){
                      bfs(grid,i,j,m,n);
                      count++;
                  }
              }
         }
         return count;
    }

    public void bfs(char[][] grid,int i,int j,int m,int n){
          Queue<int[]> q=new LinkedList<>();
          q.add(new int[]{i,j});
          int dir[][]={{0,1},{1,0},{-1,0},{0,-1}};
          while(!q.isEmpty()){
                int sz=q.size();
                while(sz>0){
                    int a[]=q.poll();
                    for(int d[]:dir){
                        if(a[0]+d[0]<0 || a[1]+d[1]<0 || a[0]+d[0]>=m || a[1]+d[1]>=n || grid[a[0]+d[0]][a[1]+d[1]]!='1')
                            continue;
                        q.add(new int[]{a[0]+d[0],a[1]+d[1]});
                        grid[a[0]+d[0]][a[1]+d[1]]='0';
                    }
                    sz--;
                }
          } 
    }
}

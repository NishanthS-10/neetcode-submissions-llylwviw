class Solution {
    public int maxAreaOfIsland(int[][] grid) {
            int m=grid.length;
         int n=grid[0].length;
         int mx=0;
         for(int i=0;i<m;i++){
              for(int j=0;j<n;j++){
                  if(grid[i][j]==1){
                      int sum=bfs(grid,i,j,m,n);
                      mx=Math.max(mx,sum);
                  }
              }
         }
         return mx;
    }

    public int bfs(int[][] grid,int i,int j,int m,int n){
          Queue<int[]> q=new LinkedList<>();
          int s=0;
          q.add(new int[]{i,j});
          grid[i][j]=0;
          int dir[][]={{0,1},{1,0},{-1,0},{0,-1}};
          while(!q.isEmpty()){
                int sz=q.size();
                s+=sz;
                //System.out.println(sz);
                 //System.out.println(s);
                while(sz>0){
                    int a[]=q.poll();
                    for(int d[]:dir){
                        if(a[0]+d[0]<0 || a[1]+d[1]<0 || a[0]+d[0]>=m || a[1]+d[1]>=n || grid[a[0]+d[0]][a[1]+d[1]]!=1)
                            continue;
                        q.add(new int[]{a[0]+d[0],a[1]+d[1]});
                        grid[a[0]+d[0]][a[1]+d[1]]=0;
                    }
                    sz--;
                }
          }
          return s; 
    }

}

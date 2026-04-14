class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
            int m=heights.length;
            int n=heights[0].length;
            boolean pf[][]=new boolean[m][n];
            boolean at[][]=new boolean[m][n];
            for(int i=0;i<n;i++){
                pf[0][i]=true;
                at[m-1][i]=true;
            }
            for(int i=0;i<m;i++){
                 pf[i][0]=true;
                 at[i][n-1]=true;
            }
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                       if(!pf[i][j] || !at[i][j]){
                          bfs(heights,i,j,m,n,pf,at);
                       }
                }
            }
            List<List<Integer>> res=new ArrayList<>();
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    List<Integer> temp=new ArrayList<>();
                    if(pf[i][j] && at[i][j]){
                        temp.add(i);
                        temp.add(j);
                        res.add(temp);
                    }
                }
            }
            return res;
    }

    public void bfs(int h[][], int i,int j,int m,int n,boolean pf[][],boolean at[][]){
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{i,j});
        int dir[][]={{0,1},{1,0},{0,-1},{-1,0}};
        boolean v[][]=new boolean[m][n];
        while(!q.isEmpty()){
             if(pf[i][j] && at[i][j]) return;
             int a[]=q.poll();
             int b=a[0];
             int c=a[1];
             for(int d[]:dir){
                int x=b+d[0];
                int y=c+d[1];
                if(x>=m || y>=n || x<0 || y<0 || v[x][y] || h[b][c]<h[x][y]) continue;
                if(at[x][y]) at[i][j]=true;
                if(pf[x][y]) pf[i][j]=true;
                if(at[i][j] && pf[i][j]) return;
                if(h[b][c]>=h[x][y] && !v[x][y])
                      { q.offer(new int[]{x,y});
                         v[x][y]=true;
                      }
             }
        }
    }
}

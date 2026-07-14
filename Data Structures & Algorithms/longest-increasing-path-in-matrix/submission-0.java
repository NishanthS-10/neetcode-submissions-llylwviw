class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int LIS=0;
        int m=matrix.length;
        int n=matrix[0].length;
        int dir[][]={{-1,0},{1,0},{0,1},{0,-1}};
        int inorder[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               for(int d[]:dir){
                    int x=i+d[0];
                    int y=j+d[1];
                    if(x>=0 && y>=0 && x<m && y<n && matrix[x][y]<matrix[i][j]){
                          inorder[i][j]++;
                    }
                }
            }
        }
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                 if(inorder[i][j]==0) q.offer(new int[]{i,j});
            }
        }
        while(!q.isEmpty()){
             int sz=q.size();
             while(sz>0){
                int arr[]=q.poll();
                int a=arr[0];
                int b=arr[1];
                for(int d[]:dir){
                    int x=a+d[0];
                    int y=b+d[1];
                    if(x>=0 && y>=0 && x<m && y<n && matrix[x][y]>matrix[a][b] && --inorder[x][y]==0){
                        q.offer(new int[]{x,y});
                    }
                }
                sz--;
             }
             LIS++;
        }
        return LIS;
    }
}

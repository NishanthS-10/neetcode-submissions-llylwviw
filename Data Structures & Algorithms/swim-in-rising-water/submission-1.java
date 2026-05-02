class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int mat[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                mat[i][j]=Integer.MAX_VALUE;
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.offer(new int[]{0,0,grid[0][0]});
        int dir[][]=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        while(!pq.isEmpty()){
            int arr[]=pq.poll();
            int x=arr[0];
            int y=arr[1];
            int c=arr[2];
           // System.out.println(c);            
            for(int d[]:dir){
                if(x+d[0]>=n || x+d[0]<0 || y+d[1]>=n || y+d[1]<0) continue;
                int curr=Math.max(grid[x+d[0]][y+d[1]],c);
                if(mat[x+d[0]][y+d[1]]>curr){
                    mat[x+d[0]][y+d[1]]=curr;
                    if(!(x+d[0]==n-1 && y+d[1]==n-1)){
                    pq.offer(new int[]{x+d[0],y+d[1],curr});
                    }
                }
            }
        }
        return mat[n-1][n-1];
    }
}

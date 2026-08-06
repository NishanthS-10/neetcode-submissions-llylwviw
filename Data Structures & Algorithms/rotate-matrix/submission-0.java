class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n;i++){
              for(int j=0;j<n/2;j++){
                 int tmp=matrix[j][i];
                 matrix[j][i]=matrix[n-j-1][i];
                 matrix[n-j-1][i]=tmp;
              }
        }
        for(int i=0;i<n;i++)
           {
              for(int j=0;j<n;j++){
                System.out.print(matrix[i][j]);
              }
              System.out.println();
           }
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }
        }
    }
}

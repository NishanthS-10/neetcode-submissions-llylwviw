class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
       int m=text1.length();
       int n=text2.length();
       int g[][]=new int[m][n];
       for(int i=0;i<n;i++){
             if(i==0 ){
             if(text1.charAt(0)==text2.charAt(i)){
                  g[0][0]=1; 
             }else g[0][0]=0;
             }else{
                 if(text1.charAt(0)==text2.charAt(i)){
                     g[0][i]=1;
             }else{
                    g[0][i]=g[0][i-1];
             }
             }
       } 
       for(int i=0;i<m;i++){
             if(i==0 ){
             if(text2.charAt(0)==text1.charAt(i)){
                  g[0][0]=1; 
             }else g[0][0]=0;
             }else{
                 if(text2.charAt(0)==text1.charAt(i)){
                     g[i][0]=1;
             }else{
                    g[i][0]=g[i-1][0];
             }
             }
       }
       for(int i=1;i<m;i++){
         for(int j=1;j<n;j++){
            if(text1.charAt(i)==text2.charAt(j)){
                g[i][j]=g[i-1][j-1]+1;
            }else{
                g[i][j]=Math.max(g[i-1][j],g[i][j-1]);
            }
         }
       }
       return g[m-1][n-1]; 
    }
}

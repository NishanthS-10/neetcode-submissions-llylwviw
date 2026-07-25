class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n+2][n+2];
        int nnums[]=new int[n+2];
        nnums[0]=nnums[n+1]=1;
        for(int i=0;i<n;i++){
            nnums[i+1]=nums[i];
        }
        for(int l=n;l>=1;l--){
            for(int r=l;r<=n;r++){
                for(int i=l;i<=r;i++){
                    int coins=nnums[l-1]*nnums[i]*nnums[r+1];
                    coins+=dp[l][i-1]+dp[i+1][r];
                    dp[l][r]=Math.max(dp[l][r],coins);
                }
            }
        }
        return dp[1][n];
    }
}

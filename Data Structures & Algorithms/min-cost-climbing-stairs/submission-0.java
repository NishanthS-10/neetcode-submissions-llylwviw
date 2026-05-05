class Solution {
    public int minCostClimbingStairs(int[] cost) {
         int n=cost.length;
         int dp[]=new int[n+1];
         dp[0]=0;
         dp[1]=0;
         dp[2]=Math.min(cost[0],cost[1]);
         for(int i=3;i<n+1;i++){
            dp[i]=Math.min(dp[i-2]+cost[i-2],dp[i-1]+cost[i-1]);
         }
         return dp[n];
    }
}

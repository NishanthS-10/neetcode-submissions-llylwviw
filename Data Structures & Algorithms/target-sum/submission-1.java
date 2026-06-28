class Solution {
    int dp[][];
    int totSum;
    public int findTargetSumWays(int[] nums, int target) {
         int n=nums.length;
         for(int a:nums) totSum+=a;
         dp=new int[n+1][2*totSum+1];
         for(int i=0;i<=n;i++){
            for(int j=0;j<=2*totSum;j++){
                dp[i][j]=Integer.MIN_VALUE;
            }
         }
         return backtrack(0,0,nums,target);
    }
     public int backtrack(int i,int tot, int nums[],int tar){
         if(i==nums.length){
             if(tot==tar) return 1;
             else return 0;
         }
         if(dp[i][tot+totSum]!=Integer.MIN_VALUE) return dp[i][tot+totSum];
         dp[i][tot+totSum]=backtrack(i+1,tot+nums[i],nums,tar)+backtrack(i+1,tot-nums[i],nums,tar);
         return dp[i][tot+totSum];
     }
}

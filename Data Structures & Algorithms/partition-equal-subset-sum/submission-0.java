class Solution {
    Boolean dp[][];
    public boolean canPartition(int[] nums) {
        int ts=0;
        int n=nums.length;
        for(int x:nums) ts+=x;
        if(ts%2!=0) return false;
        dp=new Boolean[n][ts/2+1];
        
        return dfs(nums,0,ts/2);
    }
    public boolean dfs(int nums[],int i,int ts){
           if(i>=nums.length){
                  return ts==0;
           }
           if(ts<0) return false;
           if(dp[i][ts]!=null){
                  return dp[i][ts];
           }
           dp[i][ts]=dfs(nums,i+1,ts)||dfs(nums,i+1,ts-nums[i]);
           return dp[i][ts];
    }

}

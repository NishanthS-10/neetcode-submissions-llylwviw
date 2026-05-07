class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int n1[]=new int[n-1];
        int n2[]=new int[n-1];
        for(int i=0;i<n-1;i++){
            n1[i]=nums[i];
             n2[i]=nums[i+1];
        }
        int dp1[]=new int[n-1];
        int dp2[]=new int[n-1];
        dp1[0]=n1[0];
        dp2[0]=n2[0];
        for(int i=1;i<n-1;i++){
            if(i==1){
                dp1[i]=Math.max(dp1[i-1],n1[i]);
                 dp2[i]=Math.max(dp2[i-1],n2[i]);
            }else{
                 dp1[i]=Math.max(dp1[i-1],dp1[i-2]+n1[i]);
                  dp2[i]=Math.max(dp2[i-1],n2[i]+dp2[i-2]);
            }
        }
        return Math.max(dp1[n-2],dp2[n-2]);
    }
}

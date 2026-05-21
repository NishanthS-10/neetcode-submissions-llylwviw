class Solution {
    public int maxProduct(int[] nums) {
        int res=nums[0];
        int curMin=1;
        int curMax=1;
        for(int num:nums){
            int tmp=num*curMax;
            curMax=Math.max(Math.max(num,curMax*num),curMin*num);
            curMin=Math.min(Math.min(curMin*num,tmp),num);
            res=Math.max(curMax,res);
        }
        return res;
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int res=nums[0];
        int n=nums.length;
        for(int i=1;i<n;i++){
            if(i%2!=0){
                int t=res^nums[i];
                if(t==0) continue;
                else return res;
            }else{
                res=nums[i];
                continue;
            }
        }
        return res;
    }
}

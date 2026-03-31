class Solution {
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> sub=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        combinationSum(nums,sub,0,0,target);
        return res;
    }
    public void combinationSum(int nums[],List<Integer> sub,int ind,int sum,int tar){
        if(sum==tar){
            res.add(new ArrayList<>(sub));
        }
        for(int i=ind;i<nums.length;i++){
            if(sum+nums[i]<=tar){
            sub.add(nums[i]);
            combinationSum(nums,sub,i,sum+nums[i],tar);
            sub.remove(sub.size()-1);
            }
        }
    }
}

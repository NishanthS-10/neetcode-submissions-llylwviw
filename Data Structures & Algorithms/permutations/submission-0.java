class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        permute(nums,new ArrayList<>(),0);
        return res;
    }
    public void permute(int nums[],List<Integer> sub,int ind){
        if(nums.length==sub.size()){
            res.add(new ArrayList<>(sub));
        }else{
            for(int i=0;i<nums.length;i++){
                if(sub.contains(nums[i])) continue;
                sub.add(nums[i]);
                permute(nums,sub,i+1);
                sub.remove(sub.size()-1);
            }
        }
    }
}

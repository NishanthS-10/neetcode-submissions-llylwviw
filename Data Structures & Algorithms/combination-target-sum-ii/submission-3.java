class Solution {
    Set<List<Integer>> res=new HashSet<>(); 
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum2(candidates,target,new ArrayList<>(),0,0);
        return new ArrayList<>(res);
    }
    public void combinationSum2(int c[],int target,List<Integer> arr,int sum,int ind){
        if(sum==target){
            res.add(new ArrayList<>(arr));
            return;
        }
        for(int i=ind;i<c.length;i++){
            if(i>ind && c[i]==c[i-1]){
                continue;
            }
            if(sum+c[i]<=target){
                arr.add(c[i]);
                combinationSum2(c,target,arr,sum+c[i],i+1);
                arr.remove(arr.size()-1);
            }else{
                return;
            }
        }
    }
}

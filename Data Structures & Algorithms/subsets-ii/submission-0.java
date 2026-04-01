class Solution {
    
     public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        res.add(new ArrayList<>());
        for(int num:nums){
            int sz=res.size();
            for(int i=0;i<sz;i++){
                List<Integer> sb=new ArrayList<>(res.get(i));
                sb.add(num);
                if(!res.contains(sb)){
                    res.add(sb);
                }
            }
        }
        return new ArrayList<>(res);
    }
}

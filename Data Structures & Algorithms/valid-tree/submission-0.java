class Solution {
    Set<Integer> hs=new HashSet<>();
    Map<Integer,Set<Integer>> mp=new HashMap<>();
    public boolean dfs(int i,int p){
        if(hs.contains(i)){
            return false;
        }
        hs.add(i);
        for(Integer j:mp.get(i)){
            if(j!=p){
                 if(!dfs(j,i))
                    return false;
            }
        }
        return true; 
    }
    public boolean validTree(int n, int[][] edges) {
         for(int i=0;i<n;i++){
            mp.put(i,new HashSet<>());
         }
         for(int e[]:edges){
            Set<Integer> hs=mp.get(e[0]);
            hs.add(e[1]);
            Set<Integer> hs1=mp.get(e[1]);
            hs1.add(e[0]);
         }
        if(!dfs(0,-1))
           return false;
        return hs.size() == n;
    }
}

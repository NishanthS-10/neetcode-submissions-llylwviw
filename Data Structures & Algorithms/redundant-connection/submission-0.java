class Solution {
    Map<Integer,Set<Integer>> hmp=new HashMap<>();
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        for(int i=0;i<=n;i++){
            hmp.put(i,new HashSet<>());
        }
        for(int e[]:edges){
            Set<Integer> hs=hmp.get(e[0]);
            hs.add(e[1]);
            Set<Integer> ks=hmp.get(e[1]);
            ks.add(e[0]);
            boolean vt[]=new boolean[n+1];
            if(dfs(e[0],-1,vt)) return e;

        }
        return new int[0];
    }
    public boolean dfs(int u,int pt,boolean vt[]){
        if(vt[u]){
            return true;
        }
        vt[u]=true;
        for(Integer v:hmp.get(u)){
            if(v==pt) continue;
            if(dfs(v,u,vt)) return true;
        }
        return false;
    }
}

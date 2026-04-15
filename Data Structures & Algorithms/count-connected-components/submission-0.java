class Solution {
    Map<Integer,Set<Integer>> hmp=new HashMap<>();
    public int countComponents(int n, int[][] edges) {
         for(int i=0;i<n;i++){
            hmp.put(i,new HashSet<>());
         }
         for(int e[]:edges){
              Set<Integer> hs=hmp.get(e[0]);
              hs.add(e[1]);
              Set<Integer> ks=hmp.get(e[1]);
              ks.add(e[0]);
         }
         int ct=0;
         Set<Integer> hs=new HashSet<>();
         for(int i=0;i<n;i++){
            if(!hs.contains(i)){
                Queue<Integer> q=new LinkedList<>();
                q.add(i);
                hs.add(i);
                while(!q.isEmpty()){
                    int a=q.poll();
                    for(Integer b:hmp.get(a)){
                        if(!hs.contains(b)){
                            q.offer(b);
                            hs.add(b);
                        }
                    }
                }
                ct++;
            }
         }
         return ct;     
    }
}

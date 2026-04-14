class Solution {
    Map<Integer,Set<Integer>> hmp=new HashMap<>();
    int indegree[];
    List<Integer> res=new ArrayList<>();
    public void dfs(int n){
         res.add(n);
         indegree[n]--;
         for(Integer a:hmp.get(n)){
            indegree[a]--;
            if(indegree[a]==0){
                 dfs(a);
            }
         }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            hmp.put(i,new HashSet<>());
        }
        for(int p[]:prerequisites){

            Set<Integer> hs=hmp.get(p[1]);
            hs.add(p[0]);
            indegree[p[0]]++;
        }
       for(int i=0;i<numCourses;i++){
           if(indegree[i]==0)
                dfs(i);
       }
        
       if(res.size()!=numCourses) return new int[0];
       int or[]=new int[numCourses];
       for(int i=0;i<numCourses;i++){
            or[i]=res.get(i);
       }
       return or;
    }
}

 

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,Set<Integer>> hmp=new HashMap<>();
        for(int p[]:prerequisites){
            if(!hmp.containsKey(p[0])){
                hmp.put(p[0],new HashSet<>());
            }
            Set<Integer> hs=hmp.get(p[0]);
            hs.add(p[1]);
        }
        boolean v[]=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!hmp.containsKey(i)) v[i]=true;
        }
        
        for(int i=0;i<numCourses;i++){
            if(v[i]) continue;
            boolean vt[]=new boolean[numCourses];
            Queue<Integer> q=new LinkedList<>();
            q.offer(i);
            vt[i]=true;
            while(!q.isEmpty()){
                int a=q.poll();
                Set<Integer> hs=hmp.get(a);
                int ct=0;
                for(Integer h:hs){
                    if(v[h]) {
                        ct++;
                    }else if(vt[h]){
                        break;
                    }else{
                        q.offer(h);
                        vt[h]=true;
                    }
                }
                if(ct==hs.size()) v[i]=true;
                if(v[i]) break;
            }
        }
        for(int i=0;i<numCourses;i++){
             if(!v[i]) return false;
        }
        return true;
    }
}

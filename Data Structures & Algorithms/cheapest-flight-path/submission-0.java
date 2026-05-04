class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
           Map<Integer,List<int[]>> hmp=new HashMap<>();
           for(int f[]:flights){
               hmp.putIfAbsent(f[0],new ArrayList<>());
           }
           for(int f[]:flights){
               hmp.get(f[0]).add(new int[]{f[1],f[2]});
           }
           int st=-1;
           Map<Integer,Integer> d=new HashMap<>();
           for(int i=0;i<n;i++){
                d.put(i,-1);
           }
           d.put(src,0);
           Queue<int[]> q=new LinkedList<>();
           q.offer(new int[]{src,0});
           while(!q.isEmpty()){
               int sz=q.size();
               st++;
               if(st<k+1){
                   while(sz>0){
                      int arr[]=q.poll();
                      int c=arr[1];
                      int s=arr[0];
                      if(hmp.containsKey(s)){
                          for(int b[]:hmp.get(s)){
                               if(d.get(b[0])==-1){
                                   d.put(b[0],c+b[1]);
                                   q.offer(new int[]{b[0],c+b[1]});
                               }else if(d.get(b[0])>c+b[1]){
                                    d.put(b[0],c+b[1]);
                                    q.offer(new int[]{b[0],c+b[1]});
                               }
                          }
                      }
                      sz--;
                   }
               }else{
                 break;
               }
           }
           return d.get(dst);
    }
}

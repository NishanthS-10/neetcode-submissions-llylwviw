public class Solution {
    Map<Integer,List<int[]>>hmp=new HashMap<>();
    Map<Integer,Integer> dis=new HashMap<>();
    public int networkDelayTime(int[][] times, int n, int k) {
        for(int i=1;i<=n;i++){
            hmp.put(i,new ArrayList<>());
            dis.put(i,Integer.MAX_VALUE);
        }
        for(int t[]:times){
            List<int[]> arr=hmp.get(t[0]);
            arr.add(new int[]{t[1],t[2]});
        }
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{k,0});
        dis.put(k,0);
        while(!q.isEmpty()){
            int arr[]=q.poll();
            int a=arr[0];
            int b=arr[1];
            if(dis.get(a)<b){
                continue;
            }
            for(int brr[]:hmp.get(a)){
                int time=brr[1];
                int node=brr[0];
                if(dis.get(node)<=time+b){
                    continue;
                }
                dis.put(node,time+b);
                q.offer(new int[]{node,time+b});
            }
        }
        int mxi=0;
        for(Map.Entry<Integer,Integer> entry:dis.entrySet()){
            mxi=Math.max(entry.getValue(),mxi);
        }
        return mxi==Integer.MAX_VALUE?-1:mxi;
    }
}

class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        int i=0;
        int n=intervals.length;
        HashMap<Integer,Integer> hmp=new HashMap<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[0]-b[0]));
        for(int q:Arrays.stream(queries).sorted().toArray()){
            while(i<n && intervals[i][0]<=q){
                int st=intervals[i][0];
                int end=intervals[i][1];
                pq.offer(new int[]{end-st+1,end});
                i++;
            }
            while(!pq.isEmpty() && pq.peek()[1]<q){
                pq.poll();
            }
            hmp.put(q,pq.isEmpty()?-1:pq.peek()[0]);
        }
        int res[]=new int[queries.length];
        int j=0;
        for(int q:queries){
            res[j]=hmp.get(q);
            j++;
        }
        return res;

    }
}

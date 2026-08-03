class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        int prevs=intervals[0][0];
        int preve=intervals[0][1];
        int n=intervals.length;
        int res=0;
        for(int i=1;i<n;i++){
            int st=intervals[i][0];
            int ed=intervals[i][1];
            if(st>=preve){
                preve=ed;
                prevs=st;
            }else{
                res++;
                preve=Math.min(ed,preve);
            }
        }
        return res;
    }
}

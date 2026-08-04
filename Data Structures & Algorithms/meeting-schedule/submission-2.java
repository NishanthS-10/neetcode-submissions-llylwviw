/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
           int n=intervals.size();
           if(n==0||n==1) return true;
           Collections.sort(intervals,(a,b)->(a.start-b.start));
           int prevs=intervals.get(0).start;
           int preve=intervals.get(0).end;
           
           for(int i=1;i<n;i++){
               int st=intervals.get(i).start;
               int ed=intervals.get(i).end;
               if(preve>st) return false;
               prevs=st;
               preve=ed;
           }
           return true;
    }
}

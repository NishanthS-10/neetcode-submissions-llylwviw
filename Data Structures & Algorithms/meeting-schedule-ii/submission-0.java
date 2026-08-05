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
    public int minMeetingRooms(List<Interval> intervals) {
         PriorityQueue<Integer> pq=new PriorityQueue<>();
         intervals.sort((a,b)->(a.start==b.start)?(a.end-b.end):(a.start-b.start));
         for(Interval it:intervals){
            if(!pq.isEmpty() && pq.peek()<=it.start){
                pq.poll();
            }
            pq.offer(it.end);
         }
         return pq.size();
    }
}

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
           PriorityQueue<Integer> pq=new PriorityQueue<>();
           for(int hd:hand) pq.offer(hd);
           while(!pq.isEmpty()){
                int i=0;
                Queue<Integer> q=new LinkedList<>();
                int prev=-1;
                while(i<groupSize && !pq.isEmpty()){
                    int a=pq.poll();
                    if(prev==-1) {
                        prev=a;
                        i++;
                        continue;
                    }
                    if(prev==a){
                        q.offer(a);
                        continue;
                    }
                    if(prev==a-1) { prev=a;
                    i++;}
                    else return false;
                }
                if(i!=groupSize) return false;
                while(!q.isEmpty()) pq.offer(q.poll());
           }

           return true;
    }
}

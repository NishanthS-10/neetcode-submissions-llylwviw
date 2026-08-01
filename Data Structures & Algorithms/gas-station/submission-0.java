class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
         int n=gas.length;
         int sumg=0;
         for(int a:gas) sumg+=a;
         int sumc=0;
         for(int a:cost) sumc+=a;
         if(sumg<sumc) return -1;
         int res=0;
         int total=0;
         for(int i=0;i<n;i++){
             total+=(gas[i]-cost[i]);
             if(total<0){
                 total=0;
                 res=i+1;
             }
         }
        if(res>=n) res=0;
        return res;
    }
}

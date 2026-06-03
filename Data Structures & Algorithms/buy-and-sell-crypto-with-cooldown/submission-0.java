class Solution {
    Map<String,Integer> dp=new HashMap<>();
    public int maxProfit(int[] prices) {
        return dfs(0,true,prices);
    }
    private int dfs(int i,boolean buy,int p[]){
         if(i>=p.length){
            return 0;
         }
         String k=i+"_"+buy;
         if(dp.containsKey(k)) return dp.get(k);
         int c=dfs(i+1,buy,p);
         if(buy){
            int b=dfs(i+1,false,p)-p[i];
            dp.put(k,Math.max(b,c));
         }else{
             int sell=dfs(i+2,true,p)+p[i];
             dp.put(k,Math.max(sell,c));
         }
         return dp.get(k);
    }
}

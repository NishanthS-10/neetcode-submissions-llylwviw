class Solution {
    Map<Integer,Integer> dp=new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        int val=dfs(coins,amount);
        return (val!=Integer.MAX_VALUE)? val:-1;
    }
    public int dfs(int c[],int a){
        if(dp.containsKey(a)) return dp.get(a);
        if(a==0) return 0;
        int res=Integer.MAX_VALUE;
        for(int cn:c){
            if(a-cn>=0){
                int rest=dfs(c,a-cn);
                if(rest!=Integer.MAX_VALUE){
                    res=Math.min(rest+1,res);
                }
            }
        }
        dp.put(a,res);
        return res;
    }
}

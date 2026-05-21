class Solution {
    Map<Integer,Boolean> dp=new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        dp.put(n,true);
        return dfs(s,wordDict,0);
    }
    public boolean dfs(String s,List<String> wordDict,int i){
        if(dp.containsKey(i)) return dp.get(i);
        for(String w:wordDict){
            if(i+w.length()<=s.length() && s.substring(i,i+w.length()).equals(w)){
               if(dfs(s,wordDict,i+w.length()))
                {dp.put(i,true);
                return true;
                }
            }
        }
        dp.put(i,false);
        return false;
    }
}

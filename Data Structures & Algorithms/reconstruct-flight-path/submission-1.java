class Solution {
    Map<String,List<String>> hmp=new HashMap<>();
    public List<String> findItinerary(List<List<String>> tickets) {
       for(int i=0;i<tickets.size();i++){
          hmp.putIfAbsent(tickets.get(i).get(0),new ArrayList<>());
       }
       tickets.sort((a,b)->(a.get(1).compareTo(b.get(1))));
       for(List<String> t:tickets){
            hmp.get(t.get(0)).add(t.get(1));
       }
       List<String> res=new ArrayList<>();
       res.add("JFK");
       if(dfs("JFK",res,tickets.size()+1)){
          return res;
       }
       return new ArrayList<>();
    }
    private boolean dfs(String s,List<String> res,int tsz){
        if(res.size()==tsz){
             return true;
        }
        if(!hmp.containsKey(s)){
            return false;
        }
        List<String> temp=new ArrayList<>(hmp.get(s));
        for(int i=0;i<temp.size();i++){
            String v=temp.get(i);
            hmp.get(s).remove(i);
            res.add(v);
            if(dfs(v,res,tsz)) return true;
            hmp.get(s).add(i,v);
            res.remove(res.size()-1);
        }
        return false;
    }
}

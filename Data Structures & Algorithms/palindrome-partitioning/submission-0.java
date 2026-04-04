class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
       
        List<String> part=new ArrayList<>();
        dfs(s,0,part,res);
        return res;
    }
    public void dfs(String s,int i,List<String> p,List<List<String>> r){
        if(i>=s.length()){
            r.add(new ArrayList<>(p));
            return;
        }
        for(int j=i;j<s.length();j++){
             if(ispali(s,i,j)){
                p.add(s.substring(i,j+1));
                dfs(s,j+1,p,r);
                p.remove(p.size()-1);
             }
        }
    }
    public boolean ispali(String s,int i,int j){
         while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
         }
         return true;
    }
}

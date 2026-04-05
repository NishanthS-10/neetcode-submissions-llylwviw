class Solution {
     List<String> temp=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        Map<Integer,String> hmap=new HashMap<>();
       
        hmap.put(2,"abc");
        hmap.put(3,"def");
        hmap.put(4,"ghi");
        hmap.put(5,"jkl");
        hmap.put(6,"mno");
        hmap.put(7,"pqrs");
        hmap.put(8,"tuv");
        hmap.put(9,"wxyz");
        if(digits.length()<=0) return temp;
        dfs(temp,digits,hmap,new StringBuilder(),0);
        return temp;
    }
    public void dfs(List<String> temp,String d,Map<Integer,String> hm,StringBuilder sb,int i){
            if(i>=d.length()){
                temp.add(sb.toString());
                return;
            }
                String h=hm.get(d.charAt(i)-'0');
                for(int q=0;q<h.length();q++){
                    sb.append(h.charAt(q));
                    dfs(temp,d,hm,sb,i+1);
                    sb.deleteCharAt(sb.length()-1);
                }
            
    }
}

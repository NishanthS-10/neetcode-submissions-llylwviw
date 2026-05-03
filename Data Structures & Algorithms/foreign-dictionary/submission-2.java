class Solution {
    public String foreignDictionary(String[] words) {
       Map<Character,Set<Character>> hmp=new HashMap<>();
       Map<Character,Integer> id=new HashMap<>();
       for(String w:words){
           for(int i=0;i<w.length();i++){
               hmp.putIfAbsent(w.charAt(i),new HashSet<>());
               id.putIfAbsent(w.charAt(i),0);
           }
       }
       for(int i=0;i<words.length-1;i++){
         String w1=words[i];
         String w2=words[i+1];
         int minLen=Math.min(w1.length(),w2.length());
         if(w1.length()>w2.length() && w1.substring(0,minLen).equals(w2.substring(0,minLen))) return "";
         for(int j=0;j<minLen;j++){
             if(w1.charAt(j)!=w2.charAt(j)){
                if(!hmp.get(w1.charAt(j)).contains(w2.charAt(j))){
                 Set<Character> st=hmp.get(w1.charAt(j));
                 st.add(w2.charAt(j));
                 id.put(w2.charAt(j),id.get(w2.charAt(j))+1);
             }
                 break;
             }
         }
       }
       Queue<Character> q=new LinkedList<>();
       for(char ch:id.keySet()){
             if(id.get(ch)==0){
                 q.offer(ch);
             }
       }
       StringBuilder res=new StringBuilder();
       while(!q.isEmpty()){
           char ch=q.poll();
           res.append(ch);
           for(char as:hmp.get(ch)){
                id.put(as,id.get(as)-1);
                if(id.get(as)==0){
                    q.offer(as);
                }
           }
       }
       if(res.length()!=id.size()){
           return "";
       }
       return res.toString();
    }
}

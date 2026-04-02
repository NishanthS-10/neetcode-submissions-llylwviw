class Solution {
    List<String> res=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate(0,0,new StringBuilder(),n);
        return res;
    }
    public void generate(int open,int close,StringBuilder sb,int n){
         if(open==n && sb.length()==2*n){
            res.add(sb.toString());
            return;
         }
         if(open<n){
            sb=sb.append('(');
            generate(open+1,close,sb,n);
            sb=sb.deleteCharAt(sb.length()-1);
         }
         if(close<open){
            sb.append(')');
            generate(open,close+1,sb,n);
            sb=sb.deleteCharAt(sb.length()-1);
         }
    }
}

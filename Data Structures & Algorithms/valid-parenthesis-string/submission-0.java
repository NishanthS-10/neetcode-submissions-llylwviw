class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> os=new Stack<>();
        Stack<Integer> cs=new Stack<>();
        Stack<Integer> ss=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='(') os.add(i);
            if(s.charAt(i)==')'){
                 if(!os.isEmpty()){
                    os.pop();
                 }else{
                    cs.add(i);
                 }
            }
            if(s.charAt(i)=='*') ss.add(i);
        }
        while(!ss.isEmpty() && (!os.isEmpty()||!cs.isEmpty())){
            int a=ss.pop();
            boolean handled=false;
            if(!os.isEmpty()){
               int b=os.peek();
               if(b<a){
                    os.pop();
                    handled=true;
               }
            }
            if(!handled && !cs.isEmpty()){
                int b=cs.peek();
                if(b>a){
                    cs.pop();
                    handled=true;
                }
            }
        }
      if(!os.isEmpty() || !cs.isEmpty()) return false;
      return true;
    }
}

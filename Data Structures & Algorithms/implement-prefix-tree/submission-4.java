class PrefixTree {
     PrefixTree pt;
     char ch;
     boolean end;
     PrefixTree child[];
    public PrefixTree() {
         this.ch='*';
         this.child=new PrefixTree[26];
         end=false;
    }

    public void insert(String word) {
          if(pt==null){
             pt=new PrefixTree();
          }
          PrefixTree temp=pt;
          
          for(int i=0;i<word.length();i++){
              if(temp.child[word.charAt(i)-'a']==null){
              temp.child[word.charAt(i)-'a']=new PrefixTree();
              temp.child[word.charAt(i)-'a'].ch=word.charAt(i);
              }
              temp=temp.child[word.charAt(i)-'a'];
          }
          temp.end=true;
    }

    public boolean search(String word) {
            PrefixTree temp=pt;
            if(temp==null) return false;
            //System.out.println(temp.ch);
            int n=word.length();
            for(int i=0;i<n;i++){
                //System.out.println(word.charAt(i));
                if(temp.child[word.charAt(i)-'a']==null) return false;
                else temp=temp.child[word.charAt(i)-'a'];
            }
            return temp.end;
    }

    public boolean startsWith(String prefix) {
              PrefixTree temp=pt;
              if(temp==null) return false;
              //System.out.println(temp.ch);
              int n=prefix.length();
            for(int i=0;i<n;i++){
                if(temp.child[prefix.charAt(i)-'a']==null) return false;
                else temp=temp.child[prefix.charAt(i)-'a'];
            }
            return true;
    }
}

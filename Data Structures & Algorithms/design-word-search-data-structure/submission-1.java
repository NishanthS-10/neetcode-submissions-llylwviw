class WordDictionary {
     WordDictionary wd;
     boolean isEnd=false;
     char ch;
     WordDictionary chld[];
    public WordDictionary() {
          this.ch='*';
          chld=new WordDictionary[26];
    }

    public void addWord(String word) {     
        if(wd==null){
            wd=new WordDictionary();
        }
        WordDictionary temp=wd;
        int n=word.length();
        for(int i=0;i<n;i++){
            if(temp.chld[word.charAt(i)-'a']==null){
                temp.chld[word.charAt(i)-'a']=new WordDictionary();
                temp.chld[word.charAt(i)-'a'].ch=word.charAt(i);
            }
            temp=temp.chld[word.charAt(i)-'a'];
        }
         temp.isEnd=true;
    }

    public boolean search(String word) {
          int n=word.length();
          if(wd==null) return false;
          WordDictionary temp=wd;
          return search(word,0,temp);
    }
    private boolean search(String word,int i,WordDictionary tmp){
         if(i>=word.length()){
                return tmp.isEnd;
         }
         for(int j=i;j<word.length();j++){
            if(word.charAt(j)!='.'){
             if(tmp.chld[word.charAt(j)-'a']==null) return false;
             tmp=tmp.chld[word.charAt(j)-'a'];
            }else{
                for(int k=0;k<26;k++){
                    if(tmp.chld[k]!=null){
                        if(search(word,j+1,tmp.chld[k]))
                              return true;
                    }
                }
                return false;
            }
         }
       return tmp.isEnd;
    }
}

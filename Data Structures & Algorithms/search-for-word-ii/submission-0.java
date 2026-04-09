class TrieNode{
      int idx=-1;
      TrieNode chld[];
      int refs;
      char ch='*';
      public TrieNode(){
            this.chld=new TrieNode[26];
            this.refs=0;
      }
      public void addWord(String word,int idx){
             TrieNode cur=this;
             cur.refs++;
             for(char c:word.toCharArray()){
                    int index=c-'a';
                    if(cur.chld[index]==null){
                        cur.chld[index]=new TrieNode();
                    }
                    cur=cur.chld[index];
                    cur.refs++;
             }
             cur.idx=idx; 
      }
}

class Solution {
    List<String> res=new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
         TrieNode root=new TrieNode();
         for(int i=0;i<words.length;i++){
            root.addWord(words[i],i);
         }
         for(int r=0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++){
                  dfs(board,root,r,c,words);
            }
         }
         return res;
    }
    private void dfs(char[][] b,TrieNode node,int r,int c,String w[]){
         if(r<0 || c<0||r>=b.length||c>=b[0].length || b[r][c]=='*' || node.chld[b[r][c]-'a']==null){
            return;
         }
         char temp=b[r][c];
         b[r][c]='*';
         TrieNode prev=node;
         node=node.chld[temp-'a'];
         if(node.idx!=-1){
            res.add(w[node.idx]);
            node.idx=-1;
            node.refs--;
            if(node.refs==0){
                 node=null;
                 prev.chld[temp-'a']=null;
                 b[r][c]=temp;
                 return;
            }
         }
         dfs(b,node,r+1,c,w);
         dfs(b,node,r-1,c,w);
         dfs(b,node,r,c+1,w);
         dfs(b,node,r,c-1,w);
         b[r][c]=temp;
    }
}

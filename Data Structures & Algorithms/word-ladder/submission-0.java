class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
           if(beginWord.equals(endWord)||beginWord.length()!=endWord.length()) return 0;
           int res=0;
           Queue<String> q=new LinkedList<>();
           q.offer(beginWord);
           while(!q.isEmpty()){
                res++;
                int sz=q.size();
                while(sz>0){
                    String s=q.poll();
                    if(s.equals(endWord)) return res;
                    for(int i=0;i<s.length();i++){
                        for(char ch='a';ch<='z';ch++){
                            String sb=s.substring(0,i)+ch+s.substring(i+1,s.length());
                            if(wordList.contains(sb)){
                                q.offer(sb);
                                wordList.remove(sb);
                            }
                        }
                    }
                    sz--;
                }
           }
           return 0;
    }
}

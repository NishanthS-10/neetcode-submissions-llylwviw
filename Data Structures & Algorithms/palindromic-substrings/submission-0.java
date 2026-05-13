class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        List<String> subs=new ArrayList<>();
        for(int i=0;i<n;i++){
             int l=i;
             int r=i+1;
             while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                  String sub=s.substring(l,l+r-l+1);
                  subs.add(sub);
                  l--;
                  r++;
             }
             l=i;
             r=i;
             while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                String sub=s.substring(l,l+r-l+1);
                subs.add(sub);
                l--;
                r++;
             }
        }
        return subs.size(); 
    }
}

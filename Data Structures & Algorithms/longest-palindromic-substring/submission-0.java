class Solution {
    public String longestPalindrome(String s) {
        int resLen=1;
        int n=s.length();
        int resIdx=0;
        for(int i=0;i<n;i++){
            int l=i;
            int r=i;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                   if(resLen<r-l+1){
                         resLen=r-l+1;
                         resIdx=l;
                   }
                   r++;
                   l--;
            }
             l=i;
            r=i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                   if(resLen<r-l+1){
                         resLen=r-l+1;
                         resIdx=l;
                   }
                   r++;
                   l--;
            }
        }
        return s.substring(resIdx,resIdx+resLen);
    }
}

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> hs=new HashSet<>();
        while(n!=1){
            int sum=0;
            while(n>0){
                int r=n%10;
                sum+=r*r;
                n=n/10;
            }
            if(hs.contains(sum)) return false;
            hs.add(sum);
            n=sum;
        }
        if(n==1) return true;
        return false;
    }
}

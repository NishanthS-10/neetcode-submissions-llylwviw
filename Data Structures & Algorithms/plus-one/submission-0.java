class Solution {
    public int[] plusOne(int[] digits) {
        int c=0;
        int n=digits.length;
        if(digits[n-1]+1>9){
            digits[n-1]=0;
            c=1;
        }else{
            digits[n-1]=digits[n-1]+1;
        }
        for(int i=n-2;i>=0 && c>0;i--){
            int r=digits[i]+c;
            if(r>9){ 
                c=1;
                digits[i]=0;
            }else{
                digits[i]=r;
                c=0;
            }

        }
        if(c==1){
            int res[]=new int[n+1];
            res[0]=1;
            for(int i=1;i<n+1;i++){
                res[i]=digits[i-1];
            }
            return res; 
        }
        return digits;
    }
}

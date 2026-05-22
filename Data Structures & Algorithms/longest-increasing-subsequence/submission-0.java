class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int t[]=new int[n];
        int size=0;
        for(int x:nums){
            int l=0;
            int h=size;
            while(l!=h){
                int mid=(l+h)/2;
                if(t[mid]>=x){
                    h=mid;
                }else{
                    l=mid+1;
                }
            }
            t[l]=x;
            if(l==size){
                size++;
            }
        }
        return size;
    }
}

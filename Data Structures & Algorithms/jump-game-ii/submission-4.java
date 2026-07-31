class Solution {
    public int jump(int[] nums) {
         int n=nums.length;
         int l=0;
         int r=0;
         int jp=0;
         while(r<n-1){
            int ft=0;
            for(int i=l;i<=r;i++){
                ft=Math.max(ft,i+nums[i]);
            }
            l=r+1;
            r=ft;
            jp++;
         }
         return jp;
    }
}

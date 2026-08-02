class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ls=new ArrayList<>();
        Map<Character,int[]> hmap=new HashMap<>();
        for(int i=0;i<s.length();i++){
              if(hmap.containsKey(s.charAt(i))){
                   int a[]=hmap.get(s.charAt(i));
                   a[1]=i;
              }else{
                  hmap.put(s.charAt(i),new int[]{i,i});
              }
        }
        int arr[][]=new int[hmap.size()][2];
        int j=0;
        for(Map.Entry<Character,int[]> e:hmap.entrySet()){
              arr[j]=e.getValue();
              j++;
        }
        Arrays.sort(arr,(a,b)->(a[0]-b[0]));
        int preva=arr[0][0];
        int prevb=arr[0][1];
        for(int i=1;i<hmap.size();i++){
            if(arr[i][0]<prevb){
                prevb=Math.max(prevb,arr[i][1]);
            }else{
                int len=prevb-preva+1;
                ls.add(len);
                preva=arr[i][0];
                prevb=arr[i][1];
            }
        }
        ls.add(prevb-preva+1);
        return ls;
    }
}

/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer,Node> gp=new HashMap<>();
    public Node cloneGraph(Node node) {
       if(node==null){
         return null;
       } 
       if(gp.containsKey(node.val)){
             return gp.get(node.val);
       }
        Node clone=new Node();
        Node tmp=clone;
        tmp.val=node.val;
        gp.put(tmp.val,tmp);
        for(int i=0;i<node.neighbors.size();i++){
            if(gp.containsKey(node.neighbors.get(i))){
                 tmp.neighbors.add(gp.get(node.neighbors.get(i)));
            }else{
                tmp.neighbors.add(cloneGraph(node.neighbors.get(i)));
            }
        }
        return clone;
    }
}
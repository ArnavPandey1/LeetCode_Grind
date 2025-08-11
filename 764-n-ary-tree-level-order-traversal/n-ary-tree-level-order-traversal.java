/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>>l1=new ArrayList<>();
        if(root==null){
            return l1;
        }
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        List<Integer>l2;
        while(!q.isEmpty()){
            l2=new ArrayList<>();
            int n=q.size();
            while(n>0){
                Node t=q.remove();
                l2.add(t.val);
                if(t.children!=null){
                    for(Node r:t.children){
                        q.add(r);
                    }
                }
                n--;
            }
            l1.add(new ArrayList<>(l2));
        }
        return l1;
    }
}
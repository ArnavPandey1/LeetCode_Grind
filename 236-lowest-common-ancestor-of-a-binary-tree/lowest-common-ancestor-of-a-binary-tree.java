/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<TreeNode>temp;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        temp=new ArrayList<>();
        List<TreeNode>l1=new ArrayList<>();
        List<TreeNode>l2=new ArrayList<>();
        traverse(root,l1,p);
        traverse(root,l2,q);
        int i=0;
        while (i < l1.size() && i < l2.size() && l1.get(i) == l2.get(i)) {
            i++;
        }
        return l1.get(i - 1);
    }
    public void traverse(TreeNode root,List<TreeNode>l,TreeNode val){
        if(root==null)
        return;
        temp.add(root);
        if(root==val){
            l.addAll(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }
        traverse(root.left,l,val);
        traverse(root.right,l,val);
        temp.remove(temp.size()-1);
    }
}
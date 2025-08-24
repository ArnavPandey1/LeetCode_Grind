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
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     List<TreeNode>l1=new ArrayList<>();
    //     traverse(root,p,l1);
    //     List<TreeNode>l2=new ArrayList<>();
    //     traverse(root,q,l2);
    //     int i=0;int j=0;TreeNode ans=root;
    //     while(i<l1.size() && j<l2.size()){
    //         if(l1.get(i)==l2.get(j))
    //         {
    //             ans=l1.get(i);
    //             i++;
    //             j++;
    //         }
    //         else{
    //             break;
    //         }

    //     }
    //     return ans;
    // }
    // public void traverse(TreeNode root,TreeNode v,List<TreeNode>l){
    //     if(root==null)
    //     return;
    //     if(root.val==v.val){
    //         l.add(root);
    //         return;
    //     }
    //     if(root.val>v.val){
    //         l.add(root);
    //         traverse(root.left,v,l);
    //     }
    //     if(root.val<v.val){
    //         l.add(root);
    //         traverse(root.right,v,l);
    //     }
    //     return;
    // }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            if(p.val<root.val && q.val<root.val){
                 root=root.left;
            }
            else if(p.val>root.val && q.val>root.val){
                root=root.right;
            }
            else{
                return root;
            }
        }
        return null;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair{
        TreeNode t;
        int v;
        Pair(TreeNode t,int v){
            this.t=t;
            this.v=v;
        }
    }
    List<Pair>l1=new ArrayList<>();
    TreeNode t2=null;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        helper(root,0);
        TreeNode t1=null;
        TreeNode t2=null;
        int max = 0;
        for (Pair p : l1) {
            max = Math.max(max, p.v);
        }
        for (Pair p : l1) {
            if (p.v == max) {
                if (t1 == null) t1 = p.t;
                t2 = p.t;
            }
        }
        return LCA(root,t1,t2);
    }
    public void helper(TreeNode root,int c){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            l1.add(new Pair(root,c));
        }
        helper(root.left,c+1);
        helper(root.right,c+1);
    }
    public TreeNode LCA(TreeNode root,TreeNode t1,TreeNode t2){
        List<TreeNode>lt1=new ArrayList<>();
        lt1.add(null);
        List<TreeNode>lt2=new ArrayList<>();
        lt2.add(null);
        newHelper(root,t1,lt1);
        newHelper(root,t2,lt2);
        for(int i=lt1.size()-1;i>=0;i--){
            if(lt1.get(i)==lt2.get(i)){
                return lt1.get(i);
            }
        }
        return null;
    }
     public void newHelper(TreeNode root,TreeNode temp,List<TreeNode>lt){
        if(root==null || lt.get(lt.size()-1)==temp){
            return;
        }
         lt.add(root);
        newHelper(root.left,temp,lt);
        newHelper(root.right,temp,lt);
        if(lt.get(lt.size()-1)!=temp)
        lt.remove(lt.size()-1);
    }
}
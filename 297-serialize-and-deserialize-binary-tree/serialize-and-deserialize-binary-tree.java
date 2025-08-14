/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

     // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        traverse(root,sb);
        return sb.toString();
    }
    public void traverse(TreeNode r,StringBuilder sb){
        if(r==null)
        {
          sb.append("null,");
            return;
        }
        sb.append(r.val).append(",");
        traverse(r.left,sb);
        traverse(r.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null||data.isEmpty())
        return null;
        String[] s=data.split(",");
        return traverse(s);
    }
    int idx=0;
    public TreeNode traverse(String[] s){
        // if(idx>=s.length || idx<0)
        // return null;
        String str=s[idx++];
        if(str.equals("null"))
        return null;
        TreeNode t=new TreeNode(Integer.parseInt(str));
        t.left=traverse(s);
        t.right=traverse(s);
        return t;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
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
    TreeNode f(TreeNode root,TreeNode p,TreeNode q)
    {
        if(root==null) return root;

        if(p.val<root.val && q.val<root.val) return f(root.left,p,q);
        else if(p.val>root.val && q.val>root.val) return f(root.right,p,q);

        return root;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return f(root,p,q);
    }
}

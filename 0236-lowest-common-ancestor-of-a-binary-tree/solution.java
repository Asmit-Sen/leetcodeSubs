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
    TreeNode f(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root==null || root==p || root==q) return root;
        //if curr node is one of the target nodes, it is bound to be LCA
        //else dfs
        TreeNode l=f(root.left,p,q);
        TreeNode r=f(root.right,p,q);

        //current node is the lca as targets are on both left and right subtrees
        if(l!=null && r!=null) return root;
        //if a target is found on a subtree, return that node, as it might be LCA
        return (l!=null)?l:r; 
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return f(root,p,q);
    }
}

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
    TreeNode foo(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return root;
        if(root==p || root==q) return root;

        TreeNode left = foo(root.left, p, q); 
        TreeNode right = foo(root.right, p, q);

        if (left!=null && right!=null) return root;
        if(left!=null) return left;
        return right;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return foo(root, p, q);
    }
}

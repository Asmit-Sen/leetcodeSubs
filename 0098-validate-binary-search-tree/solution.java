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
    boolean dfs(TreeNode root, double lb, double ub)
    {
        if(root==null) return true;
        return (root.val>lb && root.val<ub && dfs(root.left,lb,root.val) && dfs(root.right,root.val,ub));
    }
    public boolean isValidBST(TreeNode root) {
        return dfs(root,Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
}

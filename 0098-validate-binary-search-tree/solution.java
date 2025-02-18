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
    boolean dfs(TreeNode root, Double lb, Double ub)
    {
        if(root==null) return true;
        return (lb<root.val && root.val<ub && dfs(root.left,lb,(double)root.val) && dfs(root.right,(double)root.val,ub));
    }
    public boolean isValidBST(TreeNode root) {
        return dfs(root,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY);
    }
}

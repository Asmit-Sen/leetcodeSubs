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
    int func(TreeNode root)
    {
        if(root.left==null && root.right==null)
        return 1;

        int l=0,r=0;
        if(root.left!=null)
        l=func(root.left);

        if(root.right!=null)
        r=func(root.right);

        return 1+(int)Math.max(l,r);
    }
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return func(root);
    }
}

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
    int max=0;
    int dfs(TreeNode root){
        if (root==null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);

        max=(int)Math.max(max, (int)Math.abs(l-r));
        return (int)Math.max(l,r)+1;
    }
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return !(max>1); 
    }
}

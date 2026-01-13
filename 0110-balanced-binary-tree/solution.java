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
    int maxi=0;
    int foo(TreeNode root){
        if (root==null) return 0;

        int left = foo(root.left);
        int right = foo(root.right);
        int d = left - right;
        maxi=(int)Math.max(maxi, (int)Math.abs(d));

        return 1+(int)Math.max(left,right);
    }
    public boolean isBalanced(TreeNode root) {
        foo(root);
        return maxi<=1;
    }
}

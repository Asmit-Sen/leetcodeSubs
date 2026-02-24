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
    int ans = 0;
    void f(TreeNode root, int prev){
        int curr = (prev<<1) + root.val;
        if(root.left==null && root.right==null) ans += curr;

        if (root.left!=null) f(root.left, curr);
        if (root.right!=null) f(root.right, curr);

    }
    public int sumRootToLeaf(TreeNode root) {
        f(root,0);
        return ans;
    }
}

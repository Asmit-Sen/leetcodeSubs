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
    int ans=0, i=0;
    void foo(TreeNode root, int k){
        if (root.left!=null) foo(root.left,k);
        i++;
        if(i>k) return;
        if (i==k) {
            ans = root.val;
            return;
        }
        if(root.right!=null) foo(root.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        foo(root, k);
        return ans;
    }
}

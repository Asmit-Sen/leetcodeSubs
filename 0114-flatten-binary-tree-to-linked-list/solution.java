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
    TreeNode right_most(TreeNode root)
    {
        if(root.right==null) return root;
        return right_most(root.right);
    }
    void f(TreeNode root)
    {
        if(root==null) return;

        TreeNode left_sub=root.left;        
        TreeNode right_sub=root.right;
        

        if(left_sub!=null)
        {
            TreeNode right_most_on_left_sub=right_most(left_sub);

            root.left=null;
            root.right=left_sub;
            right_most_on_left_sub.right=right_sub;
        }

        f(root.right);
    }
    public void flatten(TreeNode root) {
        f(root);
    }
}

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
    TreeNode f=null,l=null,prev=null;
    void inorder(TreeNode root)
    {
        if(root==null) return;

        inorder(root.left);
        if(prev!=null && prev.val>root.val)
        {
            //update f and l
            if(f==null)
            {
                f=prev;
                l=root;
            }
            else
            l=root;
        }
        prev=root;
        inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
        inorder(root);
        //swap f and l
        int temp=f.val;
        f.val=l.val;
        l.val=temp;
    }
}

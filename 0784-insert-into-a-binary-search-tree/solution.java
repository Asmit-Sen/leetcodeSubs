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
    // boolean leaf(TreeNode root)
    // {
    //     return (root.left==null && root.right==null);
    // }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null)
        return new TreeNode(val);

        TreeNode node=root,prev=root;
        while(root!=null)
        {
            prev=root;
            if(val<root.val)
            root=root.left;
            else  
            root=root.right;
        }
        TreeNode temp=new TreeNode(val);
        if(val<prev.val)
        prev.left=temp;
        else prev.right=temp;
        return node;
    }
}

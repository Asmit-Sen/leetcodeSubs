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
    TreeNode bst(TreeNode root, int target)
    {
        // if(root==null) return null;

        // if(root.val==target) return root;

        // else if(target<root.val)
        // return bst(root.left,target);

        // else
        // return bst(root.right,target);


        while(root!=null && root.val!=target)
        {
            root = (target<root.val)? root.left : root.right;
        }
        return root;
    }
    public TreeNode searchBST(TreeNode root, int val) {
        return bst(root,val);
    }
}

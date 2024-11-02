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
    TreeNode smallest(TreeNode root)
    {
        while(root.left!=null)
            root=root.left;
        return root;
    }
    TreeNode f(TreeNode root)
    {
        if(root.left==null)
        return root.right;
        else if(root.right==null)
        return root.left;

        // if both the children exist,
        // replace parent with parent.right 
        //and join the parent.right->left to greatest child leaf in par->left subtree

        TreeNode leftChild=root.left;
        TreeNode smallest= smallest(root.right);//smalleston the right subtree
        smallest.left=leftChild;
        return root.right;

    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;

        if(root.val==key)
        {
            root=f(root);
        }

        TreeNode dummy=root;
        while(root!=null)
        {
            //we stop at the parent and check if any of the children is the target node
            if(key<root.val)
            {
                if(root.left!=null && root.left.val==key)
                {
                    //root is the parent
                    //left child is the target
                    root.left=f(root.left); //returns appropriate joining node
                    break;
                }
                else root=root.left;
            }
            else 
            {
                if(root.right!=null && root.right.val==key)
                {
                    //root is the parent
                    //right child is the target
                    root.right=f(root.right);
                }
                else root=root.right;
            }
        }
        return dummy;
    }
}

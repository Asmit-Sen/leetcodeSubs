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
    int f(TreeNode root, int maxi[])
    {
        if(root==null) return 0;

        int l=0,r=0;
        // // works only for atleast 1 +ve subtree
        // if (root.left!=null) l=f(root.left,maxi);
        // if (root.right!=null) r=f(root.right,maxi);

        // if both subtrees are -ve, its better to leave them and take 0 instead
        
        if (root.left!=null) l=(int)Math.max(0,f(root.left,maxi));
        if (root.right!=null) r=(int)Math.max(0,f(root.right,maxi));

        maxi[0]=(int)Math.max(maxi[0],root.val+l+r);
        return root.val+(int)Math.max(l,r);
    }
    public int maxPathSum(TreeNode root) {
        int maxi[]={Integer.MIN_VALUE};
        if(root==null)return 0;

        f(root,maxi);
        return maxi[0];
        
    }
}

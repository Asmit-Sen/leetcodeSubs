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
    boolean f(TreeNode p, TreeNode q)
    {

        //root compare
        if(p==null || q==null)
        return (p==q);

        boolean l=false,r=false;
        l=f(p.left, q.left);
        r=f(p.right, q.right);
        return p.val==q.val && l && r;

    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q==null) return (p==q);
        return f(p,q);
    }
}

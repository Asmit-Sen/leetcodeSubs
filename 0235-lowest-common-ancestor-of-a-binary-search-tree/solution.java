/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode foo(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return root;

        if (root.val > p.val && root.val > q.val) 
        return foo(root.left,p,q);
        else if (root.val < p.val && root.val < q.val) 
        return foo(root.right,p,q);

        return root;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return foo(root, p, q);
    }
}

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
    boolean dfs(TreeNode root, TreeNode sub){
        if(root.val==sub.val) {
            boolean res = search(root, sub);
            if (res) return true;    
        }

        boolean l=false, r=false;
        if (root.left!=null) l=dfs(root.left, sub);
        if (root.right!=null) r=dfs(root.right, sub);
        return l | r;
    }

    boolean search(TreeNode root, TreeNode sub){
        if (sub==null) return (root==null);
        if (sub!=null && root==null) return false;
        if (root.val!=sub.val) return false;

        return search(root.left, sub.left) & search (root.right, sub.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        return dfs(root, subRoot);
    }
}

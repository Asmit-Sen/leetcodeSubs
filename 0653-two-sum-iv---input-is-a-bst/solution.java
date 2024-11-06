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
    boolean dfs(TreeNode root, Set<Integer> set, int k)
    {
        if(root==null) return false;
        int compli=k-root.val;
        if(set.contains(compli)) return true;

        set.add(root.val);
        return (dfs(root.left,set,k) || dfs(root.right,set,k));
    }
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        return dfs(root,new HashSet<>(),k);
    }
}

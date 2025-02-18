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
    void dfs(TreeNode root, int k[], int ans[])
    {
        if(root==null) return;

        dfs(root.left,k,ans);
        // process
        k[0]--;
        if(k[0]==0) ans[0]=root.val;
        dfs(root.right,k,ans);
    }
    public int kthSmallest(TreeNode root, int k) {
        int ans[]={0};
        int cnt[]={k};
        dfs(root,cnt,ans);
        return ans[0];
    }
}

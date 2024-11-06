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
    void dfs(TreeNode root , int ans[], int k[])
    {
        if(root==null) return;
        
        dfs(root.left,ans,k);
        k[0]--;
        if(k[0]==0)
        {
            ans[0]=root.val;
            return;
        }
        dfs(root.right,ans,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        int ans[]={-1};
        int t[]={k};
        dfs(root,ans,t);
        return ans[0];
    }
}

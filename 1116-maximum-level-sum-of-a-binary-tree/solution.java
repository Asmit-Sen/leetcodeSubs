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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int maxi = (int)Integer.MIN_VALUE, 
        level = 1, ans = 0;

        q.offer(root);
        int sum = 0;

        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode top = q.poll();
                sum += top.val;
                if(top.left!=null) 
                q.offer(top.left);
                if(top.right!=null) 
                q.offer(top.right);
            }
            if(sum > maxi){
                maxi = sum;
                ans = level;
            }
            level++;
            sum=0;
        }

        return ans;


    }
}

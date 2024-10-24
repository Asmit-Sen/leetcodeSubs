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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null) return ans;
        int f=0;
        q.offer(root);
        while(!q.isEmpty())
        {
            int n=q.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                root=q.poll();
                if(root.left!=null) q.offer(root.left);
                if(root.right!=null) q.offer(root.right);
                if(f==0)// forward
                    list.add(root.val);
                else// backward
                    list.add(0,root.val);
            }
            ans.add(list);
            f=f^0^1;
        }
        return ans;
    }
}

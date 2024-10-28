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
 class Pair
 {
    TreeNode root;
    int ind;
    Pair(TreeNode root, int ind)
    {
        this.root=root;
        this.ind=ind;
    }    
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q=new LinkedList<>();
        int maxw=0;
        if(root==null) return maxw;

        q.offer (new Pair(root,0));
        while(!q.isEmpty())
        {
            int n=q.size();
            int left=0,right=0;
            int mini=q.peek().ind; // should be adjusted for overflow
            for(int j=0;j<n;j++)
            {
                int i=q.peek().ind-mini;//adjust before pushing children
                root=q.poll().root;
                
                if(j==0) left=i;
                if(j==n-1) right=i; // store the left most and right most in curr level
                
                if(root.left!=null) q.offer(new Pair(root.left,2*i+1));
                if(root.right!=null) q.offer(new Pair(root.right,2*i+2));
                
            }
            maxw=(int)Math.max(maxw,right-left+1);// keep updating max for every level
        }
        return maxw;
    }
}

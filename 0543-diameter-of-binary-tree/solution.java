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
    int maxi=0;
    int dia(TreeNode root, int[] maxi)
    {
        if(root==null) return 0;

        int leftpath=dia(root.left,maxi);
        int rightpath=dia(root.right,maxi);

        maxi[0]=(int)Math.max(maxi[0],leftpath+rightpath);
        return 1+(int)Math.max(leftpath,rightpath);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int maxi[]={0};// for pass by refernce
        dia(root,maxi);        
        return maxi[0];
    }
}

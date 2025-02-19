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
    TreeNode f( int ub, int[]preorder, int i[])
    {
        if(i[0]==preorder.length || preorder[i[0]]>=ub) return null;

        // create
        TreeNode node=new TreeNode(preorder[i[0]]);
        i[0]++;

        node.left=f(node.val,preorder,i);
        node.right=f(ub,preorder,i);
        
        return node;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int i[]={0};
        return f( Integer.MAX_VALUE, preorder, i);
    }
}

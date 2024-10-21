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
    // int f(TreeNode root, int flag[])
    // {
    //     if(root==null) return 0;
    //     int l=0,r=0;

    //     l=f(root.left,flag);
    //     r=f(root.right,flag);

    //     if(Math.abs(l-r)>1)
    //     flag[0]=0; // false

    //     return 1+(int)Math.max(l,r);
    // }

    int f(TreeNode root)
    {
        if(root==null) return 0;
        int l=0,r=0;

        l=f(root.left);
        r=f(root.right);

        if(l==-1 || r==-1) return -1;
        if(Math.abs(l-r)>1)
        return -1; // if false gives -1 

        return 1+(int)Math.max(l,r);//if true, returns height and we continue 
    }
    public boolean isBalanced(TreeNode root) {
        // int flag[]={1};
        // f(root,flag);
        // return (flag[0]==1);

        return f(root)!=-1;
    }
}

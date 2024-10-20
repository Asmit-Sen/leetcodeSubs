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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st=new Stack<>();
        List<Integer> list=new ArrayList<>();
        TreeNode node=root;
        if(root==null) return list;
        while(true)
        {
            if(node!=null)
            {
                st.push(node);
                node=node.left;
            }
            else
            {
                if(st.isEmpty())
                return list;

                list.add(st.peek().val);
                node=st.pop().right;
            }
        }
    }
}

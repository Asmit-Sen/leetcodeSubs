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
    long f(TreeNode root, Map<TreeNode, Long> map){
        if (root==null) return 0;
        long left = f(root.left, map);
        long right = f(root.right, map);
        
        long sum = root.val + 
        left + right ; 
        
        map.put(root, sum);
        return sum;
    }
    void foo(TreeNode root, 
    Map<TreeNode, Long> map, long ans[],long total){
        if (root==null) return;
        long left = 0, right = 0;
        //prune the left branch of root
        if (root.left!=null) left = map.get(root.left);
        right = total - left;
        ans[0]=Math.max(ans[0],(long) left*right);
        
        // prune the right branch of root
        if (root.right!=null) right = map.get(root.right);
        left = total - right;
        ans[0]=Math.max(ans[0], (long) left*right);

        foo(root.left, map, ans, total);
        foo(root.right, map, ans, total);

    }
    public int maxProduct(TreeNode root) {
        Map<TreeNode, Long> map = new HashMap<>();
        long total = f(root, map);
        long mod = (long)1e9+7;
        long ans[]={0};
        foo(root, map, ans, total);

        return (int)(ans[0] % mod);

    }
}

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
    boolean isLeaf(TreeNode root){
        return root.left==null && root.right==null;
    }

    void findPaths (TreeNode root, int target, List<Integer> path, List<List<Integer>> ans){

        if(root==null) return ;
        path.add(root.val);

        if(root.val==target && isLeaf(root))
        ans.add(new ArrayList<>(path));

        findPaths(root.left, target-root.val, path, ans);
        findPaths(root.right, target-root.val, path, ans);
    
        path.remove(path.size()-1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path= new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        findPaths ( root, targetSum, path, ans);
        return ans;

    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    void dfs(TreeNode root, Map<TreeNode, TreeNode> map)
    {
        if(root==null) return;

        if(root.left!=null)
        map.put(root.left,root);
        if(root.right!=null)
        map.put(root.right,root);

        dfs(root.left,map);
        dfs(root.right,map);
    }

    void f(TreeNode root, int k, List<Integer> ans, List<TreeNode> visited, Map<TreeNode, TreeNode> map)
    {
        if(root==null) return;
        
        visited.add(root);
        if(k==0) 
            ans.add(root.val);
        
        if(map.containsKey(root) && !visited.contains(map.get(root))) f(map.get(root),k-1,ans,visited,map);
        if(root.left!=null && !visited.contains(root.left)) f(root.left,k-1,ans,visited,map);
        if(root.right!=null && !visited.contains(root.right)) f(root.right,k-1,ans,visited,map);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //radial traverse
        Map<TreeNode,TreeNode> map=new HashMap<>();
        //dfs
        dfs(root,map);
        List<Integer> ans=new ArrayList<>();

        f(target,k,ans,new ArrayList<>(),map);
        return ans;
    }
}

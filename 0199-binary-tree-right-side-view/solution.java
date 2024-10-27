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
// class Pair
// {
//     TreeNode root;
//     int level;
//     Pair (TreeNode root,int level)
//     {
//         this.root=root;
//         this.level=level;
//     }
// }
class Solution {
    void dfs(TreeNode root, int level, List<Integer> ans)
    {
        if(root==null) return;
        if(ans.size()==level)
        ans.add(root.val);

        dfs(root.right,level+1,ans);
        dfs(root.left,level+1,ans);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        
        // q.offer(new Pair(root,0));
        // Queue<Pair> q=new LinkedList<>();
        // TreeMap<Integer,Integer> map= new TreeMap<>();
        // while(!q.isEmpty())
        // {
        //     int n=q.size();
        //     for(int i=0;i<n;i++)
        //     {
        //         root=q.peek().root;
        //         int l=q.poll().level;
                
        //         map.put(l,root.val);
                
        //         if(root.left!=null)
        //         q.offer(new Pair(root.left,l+1));
        //         if(root.right!=null)
        //         q.offer(new Pair(root.right,l+1));
        //     }
        // }
        
        // for(int v: map.keySet())
        // {
        //     ans.add(map.get(v));
        // }

        dfs(root,0,ans);
        return ans;
    }

}

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
    void bfs1(TreeNode root, Map<TreeNode,TreeNode> map)
    {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
            root=q.poll();
            if(root.left!=null)
            {
                map.put(root.left,root);
                q.offer(root.left);
            }
            if(root.right!=null)
            {
                map.put(root.right,root);
                q.offer(root.right);
            }
        }
    }
    void bfs2(TreeNode root, Map<TreeNode,TreeNode> map, int k, List<Integer> ans)
    {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        Set<TreeNode> set=new HashSet<>();
        while(k>0 && !q.isEmpty())
        {
            int n=q.size();
            for(int i=0;i<n;i++)
            {
                root=q.poll();
                set.add(root); // mark curr as visited
                if(root.left!=null && !set.contains(root.left))
                    q.offer(root.left);
                
                if(root.right!=null && !set.contains(root.right))
                    q.offer(root.right);

                if(map.containsKey(root) && !set.contains(map.get(root)))
                    q.offer(map.get(root));
            }// decrese dist after after every radial traversal
            k--;
        }
        //when k=0, the level we have in queue is at dist k
        while(!q.isEmpty())
            ans.add(q.poll().val);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        Map<TreeNode,TreeNode> map= new HashMap<>();
        bfs1(root,map); // children-> parent
        bfs2(target,map,k,ans);
        return ans;
    }
}

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
    class Node {
        TreeNode node;
        int level;

        Node(TreeNode node, int level){
            this.node=node;
            this.level=level;
        }
    }
    TreeNode foo(TreeNode root, TreeNode p, TreeNode q ){
       if (root==null || root==p || root==q) return root;

       TreeNode left=foo(root.left, p, q);
       TreeNode right=foo(root.right, p, q);
       if(left!=null && right!=null) return root;
       if(left!=null) return left;
       return right;

    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        //do a bfs 
        //lca of the left and right most nodes

        if(root==null) return null;

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(root,0));

        int maxLevel=0;
        Map<Integer, List<TreeNode>> map = new HashMap<>();

        
        while(!q.isEmpty()){
            Node top = q.poll();
            TreeNode topNode = top.node;
            int currLevel = top.level;

            // if(map.get(currLevel)==null)
            // map.put(currLevel, new ArrayList<>());

            List<TreeNode> nodeList = map.getOrDefault(currLevel, new ArrayList<>());
            nodeList.add(topNode);
            map.put(currLevel, nodeList);

            maxLevel = (int)Math.max(maxLevel, currLevel);

            if(topNode.left!=null) q.offer(new Node(topNode.left, currLevel+1));
            if(topNode.right!=null) q.offer(new Node(topNode.right, currLevel+1));
        }

        // for(Integer x : map.keySet()) {
        //     System.out.print("Level " + x + " -> ");
        //     for(TreeNode n : map.get(x))
        //         System.out.print(n.val +", ");
        //     System.out.println();
        // }
        // System.out.println("Max Level = "+ maxLevel);

        if (maxLevel==0 || map.get(maxLevel).size()==1) return map.get(maxLevel).get(0);

        //list of nodes in the last level
        List<TreeNode> lastLevel = map.get(maxLevel);

        return foo(root, 
        lastLevel.get(0), lastLevel.get(lastLevel.size()-1));

    }
}

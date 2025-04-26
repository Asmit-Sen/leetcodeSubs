class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj =new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());

        // int n=prerequisites.length;
        int indegree[]=new int[numCourses];

        
        for(int i=0;i<prerequisites.length;i++){
            int cur=prerequisites[i][0];
            int prev=prerequisites[i][1];
            adj.get(prev).add(cur);

            indegree[cur]++;
        }

        //topo sort
        //detect if acyclic using kahn's algo
        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<numCourses;i++)
        if (indegree[i]==0) q.offer(i);
        int ans[]=new int[numCourses];
        int pos=0;

        while(!q.isEmpty()){
            int node=q.poll();
            ans[pos++]=node;
            for(int nbr:adj.get(node)){
                indegree[nbr]--;
                if(indegree[nbr]==0) q.offer(nbr);
            }
        }
        if(pos==numCourses) return ans;
        return new int[0];
    }
}

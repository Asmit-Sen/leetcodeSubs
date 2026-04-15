class Solution {
    class dsu{
        int size[];
        int parent[];

        dsu(int n){
            size=new int[n];
            parent=new int[n];

            for(int i=0;i<n;i++) parent[i]=i;
            Arrays.fill(size,1);
        }

        int find(int node){
            if (parent[node]==node) return parent[node];
            return parent[node]=find(parent[node]);
        }

        boolean same(int u,int v){
            return find(u)==find(v);
        }

        void union(int u, int v){
            if (same(u,v)) return;
            
            int pu=find(u);
            int pv=find(v);

            if (size[pu]<=size[pv]){
                parent[pu]=pv;
                size[pv]+=size[pu];
            }
            else{
                parent[pv]=pu;
                size[pu]+=size[pv];
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        dsu ds = new dsu(accounts.size());

        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<accounts.size(); i++){
            for (int j=1; j<accounts.get(i).size(); j++){
                String email = accounts.get(i).get(j);
                if (map.containsKey(email))
                    ds.union(i, map.get(email));
                else
                    map.put(email, i);
            }
        }

        // for(int i=0;i<accounts.size(); i++) System.out.println(ds.parent[i]);

        List<TreeSet<String>> merged_emails = new ArrayList<>();
        for(int i=0; i<accounts.size(); i++) merged_emails.add(new TreeSet<>());

        for(int i=0; i<accounts.size(); i++){
            int leader = ds.find(i);

            // take all the emails of curr and add it to leader
            for(int j=1; j<accounts.get(i).size(); j++){
                String email = accounts.get(i).get(j);
                merged_emails.get(leader).add(email);
            }
        }
        
        // System.out.println(merged_emails);

        // transform into list of lists of the merged accounts and the names
        List<List<String>> list = new ArrayList<>();

        for(int i=0;i<accounts.size();i++){
            if (merged_emails.get(i).isEmpty()) continue;

            list.add(new ArrayList<>());
            
            String name = accounts.get(i).get(0);
            list.get(list.size()-1).add(name);
            
            for(String email : merged_emails.get(i))
                list.get(list.size()-1).add(email);
        }       
        return list;
    }
}

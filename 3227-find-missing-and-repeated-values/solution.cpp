class Solution {
public:
    vector<int> findMissingAndRepeatedValues(vector<vector<int>>& grid) {
        int n=grid.size();
        vector<int> a(n*n,0);
        for(auto item:grid)
        {
            for(auto it:item)
            {
                // cout<<it<<',';
                a[it-1]++;
            }
        }
        // for(auto it:a)
        // cout<<it;

        int missing=-1,repeat=-1;
        for(int i=0;i<n*n;i++)
        {
            if(a[i]==0) 
            missing=i+1;
            if(a[i]==2) 
            repeat=i+1;
        }
        return {repeat,missing};
    }
};

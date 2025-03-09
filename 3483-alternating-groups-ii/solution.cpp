class Solution {
public:
    int numberOfAlternatingGroups(vector<int>& colors, int k) {
        int n=colors.size();
        colors.insert(colors.end(),colors.begin(), colors.begin()+(k-1));

        int l=0,r=1,c=0;
        while(r<colors.size())
        {
            if(colors[r]==colors[r-1]) 
            l=r;
            c+=(r-l+1)>=k?1:0;

            r++;
        }
        return c;
    }
};

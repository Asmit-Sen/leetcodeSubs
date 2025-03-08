class Solution {
public:
    int minimumRecolors(string blocks, int k) {
        int mini=0, mm=0;
        for(int i=0;i<k;i++)
        {
            if(blocks[i]=='W') mm++;
        }
        mini=mm;
        int l=0,r=k-1;
        // mm=0;
        while(r<blocks.size()-1)
        {
            r++;
            if(blocks[r]=='W') mm++;
            if(blocks[l]=='W') mm--;
            l++;

            mini=min(mini,mm);
        }
        return mini;

    }
};

class Solution {
public:
    int f(int i, int target, vector<int>& coins, vector<vector<int>>& dp)
    {
        if(target==0) return 1;
        if(i==0) return (target%coins[0]==0);

        if(i<0) return 0;
        if(dp[i][target]!=-1) return dp[i][target];

        int l=0,r=0;
        l=f(i-1,target,coins,dp);
        if(target>=coins[i]) r=f(i,target-coins[i],coins,dp);

        return dp[i][target]=l+r;    
    }
    int change(int target, vector<int>& coins) {
        int n=coins.size();
        // vector<vector<int>> dp(n,vector<int>(target+1,0));

        vector<int> prev(target+1,0);

        prev[0]=1;
        for(int t=0;t<=target;t++)
        prev[t]=(t%coins[0]==0);


        // for(int i=0;i<n;i++)
        // dp[i][0]=1;//if target=0

        // for(int t=0;t<=target;t++)
        // dp[0][t]=(t%coins[0])==0;// only 1 coin left

        long long int l=0,r=0;
        for(int i=1;i<n;i++)
        {
            vector<int> cur(target+1,0);
            cur[0]=1;
            for(int t=1;t<=target;t++)
            {
                l=0;r=0;//note
                l=prev[t];
                if(t>=coins[i]) r=cur[t-coins[i]];
                cur[t]=l+r;
            }
            prev=cur;
        }
        return prev[target];

        // return f(n-1,target,coins,dp);
    }
};

class Solution {
public:
    vector<int> closestPrimes(int left, int right) {
        vector<int> seive(right+1,1);
        seive[1]=0;
        for(int i=2;i*i<=right;i++)
        {
            if(seive[i]==1)//prime, mark all other multiples non-prime
            {
                for(int j=i*i;j<=right;j+=i)
                seive[j]=0;
            }
        }
        int mini=1e9;
        vector<int>prime;
        vector<int> ans={-1,-1};


        for(int i=left;i<=right;i++)
        {
            if(seive[i]==1)
            prime.push_back(i);
        }
        if(prime.size()<2) return ans;

        for(int i=1;i<prime.size();i++)
        {
            int d=prime[i]-prime[i-1];
            if(d<mini)
            {
                mini=d;
                ans={prime[i-1],prime[i]};
            }
        }
        return ans;
        
    }
};

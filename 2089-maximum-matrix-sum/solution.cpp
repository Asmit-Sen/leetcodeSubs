class Solution {
public:
    // #define ll long long ;
    long long maxMatrixSum(vector<vector<int>>& matrix) {
        long long sum=0;
        int n=matrix.size(), cnt=0, mini=INT_MAX;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]<0) cnt++;
                mini=min(abs(matrix[i][j]), mini);
                sum+=abs(matrix[i][j]);
            }
        }
        if(!(cnt&1)) return sum;
        return (long long)(sum-2*mini);
    }
};

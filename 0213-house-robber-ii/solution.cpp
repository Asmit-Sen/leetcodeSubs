class Solution {
public:
    long long int f(int i, vector<int>& nums, vector<int>& dp) {
        if (i < 0) return 0;  // Base case
        if (dp[i] != -1) return dp[i];

        long long int l = f(i - 1, nums, dp); // Don't pick current house
        long long int r = nums[i] + f(i - 2, nums, dp); // Pick current house

        return dp[i] = max(l, r);
    }

    int rob(vector<int>& nums) {
        int n = nums.size();
        if (n == 1) return nums[0]; // Edge case: Only one house

        vector<int> a(nums.begin(), nums.end() - 1);
        vector<int> b(nums.begin() + 1, nums.end());

        vector<int> dp1(n - 1, -1);
        vector<int> dp2(n - 1, -1);

        long long res1 = f(a.size() - 1, a, dp1);
        long long res2 = f(b.size() - 1, b, dp2);

        return (int) max(res1, res2);
    }
};


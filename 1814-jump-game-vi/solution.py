class Solution:
    # def f(self, i, k, nums, dp):
    #     if (i>=len(nums)):
    #         return 0
    #     if dp[i] != -1:
    #         return dp[i]

    #     ans = int(-1e9)
    #     for j in range (1, k+1):
    #         ans = max(ans, nums[i] + self.f(i+j, k, nums, dp)) 
    #     dp[i] = ans
    #     return dp[i]

    def maxResult(self, nums: List[int], k: int) -> int:
        n = len(nums)
        dp = [0] * n
        dp[0] = nums[0]
        
        # Deque stores indices; values are kept in descending order of dp[index]
        dq = deque([0])
        
        for i in range(1, n):
            # 1. Remove indices out of range [i-k, i-1]
            if dq[0] < i - k:
                dq.popleft()
            
            # 2. The best previous jump is at the front of the deque
            dp[i] = nums[i] + dp[dq[0]]
            
            # 3. Maintain monotonic property: remove elements smaller than current dp[i]
            while dq and dp[dq[-1]] <= dp[i]:
                dq.pop()
                
            dq.append(i)
            
        return dp[-1]

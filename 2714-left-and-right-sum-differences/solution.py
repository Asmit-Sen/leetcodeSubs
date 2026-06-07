class Solution:
    def leftRightDifference(self, nums: List[int]) -> List[int]:
        ans = []
        S = sum(nums)
        n=len(nums)

        cur = 0
        for i in range(n):
            ans.append(abs(2*cur - S + nums[i]))
            cur += nums[i]

        return ans

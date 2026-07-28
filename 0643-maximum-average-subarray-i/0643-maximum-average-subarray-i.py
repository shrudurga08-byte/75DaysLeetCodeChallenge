class Solution(object):
    def findMaxAverage(self, nums, k):

        window_sum = sum(nums[:k])
        max_sum = window_sum

        for i in range(k, len(nums)):
            window_sum = window_sum + nums[i] - nums[i-k]

            if window_sum > max_sum:
                max_sum = window_sum

        return float(max_sum) / k
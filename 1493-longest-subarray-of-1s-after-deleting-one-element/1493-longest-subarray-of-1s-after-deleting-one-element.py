class Solution(object):
    def longestSubarray(self, nums):

        left = 0
        zero = 0
        maximum = 0

        for right in range(len(nums)):

            if nums[right] == 0:
                zero += 1

            while zero > 1:
                if nums[left] == 0:
                    zero -= 1
                left += 1

            maximum = max(maximum, right - left)

        return maximum
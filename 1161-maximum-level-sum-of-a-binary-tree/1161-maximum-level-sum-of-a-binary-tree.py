# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def maxLevelSum(self, root):

        queue = [root]
        level = 1

        max_sum = float('-inf')
        answer = 1

        while queue:

            size = len(queue)
            total = 0

            for i in range(size):
                node = queue.pop(0)
                total += node.val

                if node.left:
                    queue.append(node.left)

                if node.right:
                    queue.append(node.right)

            if total > max_sum:
                max_sum = total
                answer = level

            level += 1

        return answer
        
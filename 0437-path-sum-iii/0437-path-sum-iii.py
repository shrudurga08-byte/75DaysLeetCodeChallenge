# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def pathSum(self, root, targetSum):

        def findPath(node, total):

            if node is None:
                return 0

            total += node.val

            count = 0

            if total == targetSum:
                count += 1

            count += findPath(node.left, total)
            count += findPath(node.right, total)

            return count

        if root is None:
            return 0

        return (findPath(root, 0)
                + self.pathSum(root.left, targetSum)
                + self.pathSum(root.right, targetSum))
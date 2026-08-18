# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def goodNodes(self, root):

        def count(node, maximum):

            if node is None:
                return 0

            if node.val >= maximum:
                good = 1
                maximum = node.val
            else:
                good = 0

            left = count(node.left, maximum)
            right = count(node.right, maximum)

            return good + left + right

        return count(root, root.val)
        
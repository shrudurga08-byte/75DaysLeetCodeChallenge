# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def longestZigZag(self, root):

        maximum = [0]

        def dfs(node, left, right):

            if node is None:
                return

            maximum[0] = max(maximum[0], left, right)

            dfs(node.left, right + 1, 0)
            dfs(node.right, 0, left + 1)

        dfs(root, 0, 0)

        return maximum[0]
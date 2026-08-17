# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def leafSimilar(self, root1, root2):

        def getLeaves(root):
            leaves = []

            if root is None:
                return leaves

            if root.left is None and root.right is None:
                leaves.append(root.val)
                return leaves

            leaves += getLeaves(root.left)
            leaves += getLeaves(root.right)

            return leaves

        return getLeaves(root1) == getLeaves(root2)     
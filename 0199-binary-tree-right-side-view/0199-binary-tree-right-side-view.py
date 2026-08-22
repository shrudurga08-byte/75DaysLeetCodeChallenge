# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def rightSideView(self, root):

        if root is None:
            return []

        queue = [root]
        result = []

        while queue:
            size = len(queue)

            for i in range(size):
                node = queue.pop(0)

                if i == size - 1:
                    result.append(node.val)

                if node.left:
                    queue.append(node.left)

                if node.right:
                    queue.append(node.right)

        return result    
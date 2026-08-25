# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):

  def deleteNode(self, root, key):
    if not root:
      return None

    # Step 1: Search for the node to delete
    if key < root.val:
      root.left = self.deleteNode(root.left, key)
    elif key > root.val:
      root.right = self.deleteNode(root.right, key)
    else:
      # Step 2: Delete the target node

      # Case 1 & 2: 0 or 1 child
      if not root.left:
        return root.right
      elif not root.right:
        return root.left

      # Case 3: 2 children
      # Find in-order successor (min value in right subtree)
      curr = root.right
      while curr.left:
        curr = curr.left

      # Replace value with in-order successor's value
      root.val = curr.val

      # Delete the in-order successor node
      root.right = self.deleteNode(root.right, curr.val)

    return root
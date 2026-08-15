class Solution(object):
    def pairSum(self, head):

        slow = head
        fast = head

        # Find middle
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # Reverse second half
        prev = None

        while slow:
            next_node = slow.next
            slow.next = prev
            prev = slow
            slow = next_node

        # Find maximum twin sum
        first = head
        second = prev
        maximum = 0

        while second:
            total = first.val + second.val
            maximum = max(maximum, total)

            first = first.next
            second = second.next

        return maximum
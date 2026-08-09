class Solution(object):
    def decodeString(self, s):

        stack = []
        number = 0
        word = ""

        for ch in s:

            if ch.isdigit():
                number = number * 10 + int(ch)

            elif ch == '[':
                stack.append((word, number))
                word = ""
                number = 0

            elif ch == ']':
                old_word, count = stack.pop()
                word = old_word + word * count

            else:
                word += ch

        return word    
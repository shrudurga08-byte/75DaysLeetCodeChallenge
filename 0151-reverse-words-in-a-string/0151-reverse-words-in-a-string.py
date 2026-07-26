class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """

        # Split the string into words
        words = s.split()

        # Reverse the list of words
        words = words[::-1]

        # Join the words with a single space
        return " ".join(words)
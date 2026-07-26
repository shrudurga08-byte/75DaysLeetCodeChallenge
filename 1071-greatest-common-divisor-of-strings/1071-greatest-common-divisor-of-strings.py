class Solution:
    def gcdOfStrings(self, str1, str2):

        # Check if concatenating in both orders gives the same result
        if str1 + str2 != str2 + str1:
            return ""

        # Find GCD of the lengths
        def gcd(a, b):
            while b:
                a, b = b, a % b
            return a

        length = gcd(len(str1), len(str2))

        return str1[:length]
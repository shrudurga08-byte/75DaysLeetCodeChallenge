class Solution(object):
    def closeStrings(self, word1, word2):

        if len(word1) != len(word2):
            return False

        count1 = {}
        count2 = {}

        for ch in word1:
            count1[ch] = count1.get(ch, 0) + 1

        for ch in word2:
            count2[ch] = count2.get(ch, 0) + 1

        if set(count1.keys()) != set(count2.keys()):
            return False

        if sorted(count1.values()) != sorted(count2.values()):
            return False

        return True     
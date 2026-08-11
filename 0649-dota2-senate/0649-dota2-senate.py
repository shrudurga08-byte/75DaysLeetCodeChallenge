class Solution(object):
    def predictPartyVictory(self, senate):

        R = []
        D = []

        for i in range(len(senate)):
            if senate[i] == 'R':
                R.append(i)
            else:
                D.append(i)

        n = len(senate)

        while R and D:

            r = R.pop(0)
            d = D.pop(0)

            if r < d:
                R.append(r + n)
            else:
                D.append(d + n)

        if R:
            return "Radiant"
        else:
            return "Dire"
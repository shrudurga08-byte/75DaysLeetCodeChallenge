class Solution(object):
    def equalPairs(self, grid):

        count = 0
        n = len(grid)

        for i in range(n):

            for j in range(n):

                row = grid[i]
                column = []

                for k in range(n):
                    column.append(grid[k][j])

                if row == column:
                    count += 1

        return count
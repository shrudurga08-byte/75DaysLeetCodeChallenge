class Solution(object):
    def asteroidCollision(self, asteroids):

        stack = []

        for a in asteroids:

            while stack and a < 0 and stack[-1] > 0:

                if stack[-1] < -a:
                    stack.pop()

                elif stack[-1] == -a:
                    stack.pop()
                    a = 0
                    break

                else:
                    a = 0
                    break

            if a != 0:
                stack.append(a)

        return stack     
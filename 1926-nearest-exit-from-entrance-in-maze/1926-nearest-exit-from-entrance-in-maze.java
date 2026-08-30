
class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {

        int m = maze.length;
        int n = maze[0].length;

        // Queue stores: row, col, steps
        Queue<int[]> queue = new LinkedList<>();

        // Add entrance
        queue.offer(new int[]{entrance[0], entrance[1], 0});

        // Mark entrance as visited
        maze[entrance[0]][entrance[1]] = '+';

        // Directions: up, down, left, right
        int[][] directions = {
            {-1, 0},   // up
            {1, 0},    // down
            {0, -1},   // left
            {0, 1}     // right
        };

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];
            int steps = current[2];

            // Explore all 4 directions
            for (int[] dir : directions) {

                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check whether the new cell is inside the maze
                if (newRow >= 0 && newRow < m &&
                    newCol >= 0 && newCol < n &&
                    maze[newRow][newCol] == '.') {

                    int newSteps = steps + 1;

                    // If this cell is on the border,
                    // it is the nearest exit
                    if (newRow == 0 || newRow == m - 1 ||
                        newCol == 0 || newCol == n - 1) {

                        return newSteps;
                    }

                    // Mark as visited
                    maze[newRow][newCol] = '+';

                    // Add to queue
                    queue.offer(new int[]{
                        newRow, newCol, newSteps
                    });
                }
            }
        }

        // No exit found
        return -1;
    }
}
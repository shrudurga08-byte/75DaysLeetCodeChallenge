class Solution {
    public int minReorder(int n, int[][] connections) {
     List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] connection : connections) {
            int a = connection[0];
            int b = connection[1];

            // a -> b is the original direction
            graph[a].add(new int[]{b, 1});

            // b -> a is the reverse direction
            graph[b].add(new int[]{a, 0});
        }

        boolean[] visited = new boolean[n];

        return dfs(0, graph, visited);
    }

    private int dfs(int city, List<int[]>[] graph, boolean[] visited) {
        visited[city] = true;

        int changes = 0;

        for (int[] edge : graph[city]) {
            int nextCity = edge[0];
            int needsChange = edge[1];

            if (visited[nextCity]) {
                continue;
            }

            // If original road is city -> nextCity,
            // it needs to be reversed to reach city 0.
            changes += needsChange;

            changes += dfs(nextCity, graph, visited);
        }

        return changes;
       
    }
}
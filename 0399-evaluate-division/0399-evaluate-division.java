class Solution {
    public double[] calcEquation(List<List<String>> equations,
                                  double[] values,
                                  List<List<String>> queries) {

        Map<String, Map<String, Double>> graph = new HashMap<>();

        // Create graph
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, values[i]);
            graph.get(b).put(a, 1 / values[i]);
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);

            ans[i] = dfs(a, b, 1.0, graph, new HashSet<>());
        }

        return ans;
    }

    double dfs(String a, String b, double value,
               Map<String, Map<String, Double>> graph,
               Set<String> visited) {

        if (!graph.containsKey(a) || !graph.containsKey(b))
            return -1.0;

        if (a.equals(b))
            return value;

        visited.add(a);

        for (String next : graph.get(a).keySet()) {
            if (!visited.contains(next)) {

                double result = dfs(
                    next, b,
                    value * graph.get(a).get(next),
                    graph, visited
                );

                if (result != -1.0)
                    return result;
            }
        }

        return -1.0;
    }
}
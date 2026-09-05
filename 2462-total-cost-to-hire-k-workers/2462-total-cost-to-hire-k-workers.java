class Solution {
    public long totalCost(int[] costs, int k, int candidates) {

        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();

        int n = costs.length;
        int i = 0;
        int j = n - 1;
        long total = 0;

        // Add first candidates
        while (i <= j && left.size() < candidates) {
            left.add(costs[i]);
            i++;
        }

        // Add last candidates
        while (i <= j && right.size() < candidates) {
            right.add(costs[j]);
            j--;
        }

        for (int count = 0; count < k; count++) {

            if (right.isEmpty() || (!left.isEmpty() && left.peek() <= right.peek())) {

                total += left.poll();

                if (i <= j) {
                    left.add(costs[i]);
                    i++;
                }

            } else {

                total += right.poll();

                if (i <= j) {
                    right.add(costs[j]);
                    j--;
                }
            }
        }

        return total;
    }
}
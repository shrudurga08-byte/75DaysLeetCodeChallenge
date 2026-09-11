class Solution {

    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k, n, 1, new ArrayList<>());
        return answer;
    }

    public void backtrack(int k, int n, int start, List<Integer> current) {

        // Correct combination found
        if (current.size() == k && n == 0) {
            answer.add(new ArrayList<>(current));
            return;
        }

        // Stop if too many numbers or sum becomes negative
        if (current.size() >= k || n < 0) {
            return;
        }

        for (int i = start; i <= 9; i++) {

            current.add(i);

            backtrack(k, n - i, i + 1, current);

            current.remove(current.size() - 1);
        }
    }
}
class Solution {

    String[] letters = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    List<String> answer = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) {
            return answer;
        }

        backtrack(digits, 0, "");

        return answer;
    }

    public void backtrack(String digits, int index, String current) {

        // All digits are used
        if (index == digits.length()) {
            answer.add(current);
            return;
        }

        int digit = digits.charAt(index) - '0';

        String possibleLetters = letters[digit];

        for (char ch : possibleLetters.toCharArray()) {
            backtrack(digits, index + 1, current + ch);
        }
    }
}
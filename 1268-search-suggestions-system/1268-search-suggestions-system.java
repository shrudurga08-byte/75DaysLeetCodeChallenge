import java.util.*;

class Solution {

    public List<List<String>> suggestedProducts(
        String[] products,
        String searchWord
    ) {

        List<List<String>> answer = new ArrayList<>();

        Arrays.sort(products);

        String prefix = "";

        for (char ch : searchWord.toCharArray()) {

            prefix = prefix + ch;

            List<String> suggestions = new ArrayList<>();

            for (String product : products) {

                if (product.startsWith(prefix)) {

                    suggestions.add(product);

                    if (suggestions.size() == 3) {
                        break;
                    }
                }
            }

            answer.add(suggestions);
        }

        return answer;
    }
}
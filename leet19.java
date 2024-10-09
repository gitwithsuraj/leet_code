import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Mapping of digits to corresponding letters.
    private static final String[] PHONE_MAP = {
            "",     // 0 and 1 don't map to any letters
            "",     // for index alignment purposes
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        // Base case for empty input
        if (digits == null || digits.length() == 0) {
            return result;
        }

        // Start the backtracking process
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder currentCombination, String digits, int index) {
        // If we have processed all digits, add the current combination to result
        if (index == digits.length()) {
            result.add(currentCombination.toString());
            return;
        }

        // Get letters corresponding to the current digit
        String letters = PHONE_MAP[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            // Append the letter and proceed to the next digit
            currentCombination.append(letter);
            backtrack(result, currentCombination, digits, index + 1);
            // Backtrack by removing the last letter
            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("23"));  // Output: [ad, ae, af, bd, be, bf, cd, ce, cf]
        System.out.println(solution.letterCombinations(""));    // Output: []
        System.out.println(solution.letterCombinations("2"));   // Output: [a, b, c]
    }
}

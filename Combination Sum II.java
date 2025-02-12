import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort to handle duplicates
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current)); // Found a combination
            return;
        }
        if (target < 0) {
            return; // Exceeded the target, no point in continuing
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            current.add(candidates[i]);
            // Move to the next index since each number can only be used once
            backtrack(candidates, target - candidates[i], i + 1, current, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] candidates1 = {10, 1, 2, 7, 6, 1, 5};
        int target1 = 8;
        System.out.println(solution.combinationSum2(candidates1, target1));

        int[] candidates2 = {2, 5, 2, 1, 2};
        int target2 = 5;
        System.out.println(solution.combinationSum2(candidates2, target2));
    }
}

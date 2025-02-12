public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // DP table to store results of subproblems
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;  // Empty pattern matches empty string
        
        // Initialize the first row for patterns with leading *
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    // '*' can match zero or more characters
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    // '?' matches any single character or exact match
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        
        return dp[m][n];
    }
    
    public static void main(String[] args) {
        Solution wm = new Solution();
        
        // Test cases
        System.out.println(wm.isMatch("aa", "a"));    // Output: false
        System.out.println(wm.isMatch("aa", "*"));    // Output: true
        System.out.println(wm.isMatch("cb", "?a"));   // Output: false
        System.out.println(wm.isMatch("adceb", "*a*b")); // Output: true
        System.out.println(wm.isMatch("acdcb", "a*c?b")); // Output: false
    }
}

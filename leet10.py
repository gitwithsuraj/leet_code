class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        m, n = len(s), len(p)
        
        # Create a DP table with default value False
        dp = [[False] * (n + 1) for _ in range(m + 1)]
        
        # Base case: empty string and empty pattern match
        dp[0][0] = True
        
        # Fill the dp table for patterns that can match an empty string
        for j in range(2, n + 1):
            if p[j - 1] == '*':
                dp[0][j] = dp[0][j - 2]  # '*' can act as empty (ignore previous character)
        
        # Fill the DP table for all s and p combinations
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if p[j - 1] == '.' or p[j - 1] == s[i - 1]:
                    # If characters match, or pattern has '.', mark as the same as without these characters
                    dp[i][j] = dp[i - 1][j - 1]
                elif p[j - 1] == '*':
                    # '*' can either act as:
                    # (1) Ignore the preceding character -> dp[i][j-2]
                    # (2) Match one more of the preceding character -> dp[i-1][j] if preceding char matches
                    dp[i][j] = dp[i][j - 2] or (dp[i - 1][j] and (p[j - 2] == '.' or p[j - 2] == s[i - 1]))
        
        # The answer is whether the whole string matches the whole pattern
        return dp[m][n]

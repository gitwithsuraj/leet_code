class Solution:
    def myAtoi(self, s: str) -> int:
        # Define the boundaries for 32-bit signed integer range
        MIN_INT, MAX_INT = -2**31, 2**31 - 1
        
        # Step 1: Ignore leading whitespace
        i, n = 0, len(s)
        while i < n and s[i] == ' ':
            i += 1
        
        # Step 2: Check for the sign
        sign = 1
        if i < n and (s[i] == '-' or s[i] == '+'):
            if s[i] == '-':
                sign = -1
            i += 1
        
        # Step 3: Convert the digits
        result = 0
        while i < n and s[i].isdigit():
            digit = int(s[i])
            
            # Check for overflow or underflow before adding the digit
            if result > (MAX_INT - digit) // 10:
                return MAX_INT if sign == 1 else MIN_INT
            
            result = result * 10 + digit
            i += 1
        
        # Apply the sign to the result
        result *= sign
        
        # Step 4: Return the bounded value
        return max(MIN_INT, min(result, MAX_INT))

# Example usages:
solution = Solution()
print(solution.myAtoi("42"))          # Output: 42
print(solution.myAtoi("   -042"))     # Output: -42
print(solution.myAtoi("1337c0d3"))    # Output: 1337
print(solution.myAtoi("0-1"))         # Output: 0
print(solution.myAtoi("words and 987"))  # Output: 0

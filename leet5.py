class Solution:
    def reverse(self, x: int) -> int:
        # Define the boundaries for 32-bit signed integer range
        MIN_INT, MAX_INT = -2**31, 2**31 - 1
        
        # Get the sign of x
        sign = -1 if x < 0 else 1
        
        # Reverse the digits by converting to a string, removing the sign, and reversing
        rev_x = int(str(abs(x))[::-1])
        
        # Apply the sign to the reversed number
        result = sign * rev_x
        
        # Check if the result is within the 32-bit signed integer range
        if result < MIN_INT or result > MAX_INT:
            return 0
        return result

# Example usages:
solution = Solution()
print(solution.reverse(123))  # Output: 321
print(solution.reverse(-123)) # Output: -321
print(solution.reverse(120))  # Output: 21

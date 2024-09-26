class Solution:
    def maxArea(self, height):
        left, right = 0, len(height) - 1
        max_area = 0

        while left < right:
            # Calculate the current area
            area = min(height[left], height[right]) * (right - left)
            # Update max_area if the current area is larger
            max_area = max(max_area, area)

            # Move the pointer pointing to the shorter line inward
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1

        return max_area

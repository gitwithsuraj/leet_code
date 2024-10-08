class Solution:
    def threeSumClosest(self, nums, target):
        nums.sort()  # Sort the array
        closest_sum = float('inf')  # Initialize closest sum to infinity for comparison

        for i in range(len(nums) - 2):
            left, right = i + 1, len(nums) - 1
            
            while left < right:
                current_sum = nums[i] + nums[left] + nums[right]
                
                # If the exact target is found, return immediately
                if current_sum == target:
                    return current_sum
                
                # Update closest_sum if the current sum is closer to the target
                if abs(target - current_sum) < abs(target - closest_sum):
                    closest_sum = current_sum
                
                # Move pointers to try to get closer to the target
                if current_sum < target:
                    left += 1  # Increase sum by moving left pointer right
                else:
                    right -= 1  # Decrease sum by moving right pointer left
        
        return closest_sum

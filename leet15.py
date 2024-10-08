class Solution:
    def threeSum(self, nums):
        nums.sort()  # Sort the array
        result = []
        
        for i in range(len(nums) - 2):
            # Skip duplicate values
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            
            left, right = i + 1, len(nums) - 1
            while left < right:
                total = nums[i] + nums[left] + nums[right]
                
                if total == 0:
                    result.append([nums[i], nums[left], nums[right]])
                    left += 1
                    right -= 1
                    
                    # Skip duplicates for left and right pointers
                    while left < right and nums[left] == nums[left - 1]:
                        left += 1
                    while left < right and nums[right] == nums[right + 1]:
                        right -= 1
                
                elif total < 0:
                    left += 1  # Increase sum by moving left pointer to the right
                else:
                    right -= 1  # Decrease sum by moving right pointer to the left
        
        return result

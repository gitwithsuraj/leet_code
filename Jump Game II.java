class Solution:
    def jump(self, nums):
        jumps = 0
        current_end = 0
        farthest = 0
        
        for i in range(len(nums) - 1):
            farthest = max(farthest, i + nums[i])
            
            # If we reach the end of the current jump range
            if i == current_end:
                jumps += 1
                current_end = farthest
                
                # If we can reach the last index, break
                if current_end >= len(nums) - 1:
                    break
                    
        return jumps

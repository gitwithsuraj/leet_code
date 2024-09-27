class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        # Ensure nums1 is the smaller array for binary search
        if len(nums1) > len(nums2):
            nums1, nums2 = nums2, nums1
        
        m, n = len(nums1), len(nums2)
        low, high = 0, m
        
        while low <= high:
            partition1 = (low + high) // 2
            partition2 = (m + n + 1) // 2 - partition1
            
            maxLeft1 = float('-inf') if partition1 == 0 else nums1[partition1 - 1]
            minRight1 = float('inf') if partition1 == m else nums1[partition1]
            
            maxLeft2 = float('-inf') if partition2 == 0 else nums2[partition2 - 1]
            minRight2 = float('inf') if partition2 == n else nums2[partition2]
            
            # Check if we have found the correct partition
            if maxLeft1 <= minRight2 and maxLeft2 <= minRight1:
                # If the total length is odd, return the max of left elements
                if (m + n) % 2 == 1:
                    return max(maxLeft1, maxLeft2)
                # If even, return the average of max left and min right elements
                else:
                    return (max(maxLeft1, maxLeft2) + min(minRight1, minRight2)) / 2
            elif maxLeft1 > minRight2:
                high = partition1 - 1
            else:
                low = partition1 + 1

class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;  // Pointer for the next position of elements not equal to val
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        
        return k;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums1 = {3, 2, 2, 3};
        int val1 = 3;
        int k1 = solution.removeElement(nums1, val1);
        System.out.println("Output: " + k1);  // Output: 2
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + " ");  // Output: 2 2 (order does not matter)
        }
        
        System.out.println();

        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;
        int k2 = solution.removeElement(nums2, val2);
        System.out.println("Output: " + k2);  // Output: 5
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + " ");  // Output: 0, 1, 3, 0, 4 (order may vary)
        }
    }
}

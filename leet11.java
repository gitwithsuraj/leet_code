class NumArray {
    private int[] prefixSums;

    // Constructor: Initializes the prefix sum array
    public NumArray(int[] nums) {
        prefixSums = new int[nums.length];
        if (nums.length > 0) {
            prefixSums[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                prefixSums[i] = prefixSums[i - 1] + nums[i];
            }
        }
    }

    // Method to return the sum of elements between indices left and right (inclusive)
    public int sumRange(int left, int right) {
        if (left == 0) {
            return prefixSums[right];
        } else {
            return prefixSums[right] - prefixSums[left - 1];
        }
    }
}

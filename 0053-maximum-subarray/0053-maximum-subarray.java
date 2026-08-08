class Solution {
    public int maxSubArray(int[] nums) {
        // Initialize the maximum sum with the first element
        int maxSum = nums[0];
      
        // Track the maximum sum ending at the current position
        int currentSum = nums[0];
      
        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Decide whether to extend the existing subarray or start a new one
            // If currentSum is negative, it's better to start fresh with nums[i]
            currentSum = Math.max(currentSum, 0) + nums[i];
          
            // Update the global maximum if current sum is larger
            maxSum = Math.max(maxSum, currentSum);
        }
      
        return maxSum;
    }
}
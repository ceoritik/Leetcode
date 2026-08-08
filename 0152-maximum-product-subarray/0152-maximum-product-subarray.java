class Solution {
    public int maxProduct(int[] nums) {
        // Initialize variables to track maximum and minimum products ending at current position
        // We track both max and min because a negative number can flip them
        int maxEndingHere = nums[0];  // Maximum product ending at current index
        int minEndingHere = nums[0];  // Minimum product ending at current index
        int globalMaxProduct = nums[0];  // Overall maximum product found so far
      
        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Store previous values before updating
            int previousMax = maxEndingHere;
            int previousMin = minEndingHere;
          
            // Calculate new maximum product ending at current position
            // It could be: 
            // 1. Current element alone (start new subarray)
            // 2. Previous max * current element (extend positive sequence)
            // 3. Previous min * current element (negative * negative = positive)
            maxEndingHere = Math.max(nums[i], 
                                    Math.max(previousMax * nums[i], 
                                            previousMin * nums[i]));
          
            // Calculate new minimum product ending at current position
            // Similar logic but looking for minimum
            minEndingHere = Math.min(nums[i], 
                                    Math.min(previousMax * nums[i], 
                                            previousMin * nums[i]));
          
            // Update global maximum if current maximum is larger
            globalMaxProduct = Math.max(globalMaxProduct, maxEndingHere);
        }
      
        return globalMaxProduct;
    }
}
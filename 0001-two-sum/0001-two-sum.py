class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # Dictionary to store number -> index mapping
        num_to_index = {}

        # Iterate through the array with index and value
        for index, num in enumerate(nums):
            # Calculate the complement needed to reach target
            complement = target - num

            # Check if complement exists in our dictionary
            if complement in num_to_index:
                # Found the pair! Return indices
                return [num_to_index[complement], index]

            # Store current number and its index for future lookups
            num_to_index[num] = index
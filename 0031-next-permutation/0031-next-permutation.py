class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Modifies the array to the next lexicographically greater permutation.
        If no such permutation exists, rearranges to the smallest permutation (sorted order).
      
        Algorithm:
        1. Find the rightmost position where nums[i] < nums[i+1] (pivot point)
        2. If found, find the smallest element greater than nums[i] from the right
        3. Swap these two elements
        4. Reverse the suffix after position i to get the next smallest permutation
        """
        n = len(nums)
      
        # Step 1: Find the rightmost ascending pair (pivot point)
        # Scan from right to left to find first decreasing element
        pivot_index = -1
        for i in range(n - 2, -1, -1):
            if nums[i] < nums[i + 1]:
                pivot_index = i
                break
      
        # Step 2: If pivot exists, find the smallest element greater than pivot from the right
        if pivot_index != -1:  # Using explicit comparison instead of ~i bitwise operation
            # Find the rightmost element greater than the pivot
            swap_index = -1
            for j in range(n - 1, pivot_index, -1):
                if nums[j] > nums[pivot_index]:
                    swap_index = j
                    break
          
            # Step 3: Swap the pivot with the found element
            nums[pivot_index], nums[swap_index] = nums[swap_index], nums[pivot_index]
      
        # Step 4: Reverse the suffix after pivot_index to get the next smallest permutation
        # This works even when pivot_index is -1 (array is in descending order)
        left = pivot_index + 1
        right = n - 1
        while left < right:
            nums[left], nums[right] = nums[right], nums[left]
            left += 1
            right -= 1

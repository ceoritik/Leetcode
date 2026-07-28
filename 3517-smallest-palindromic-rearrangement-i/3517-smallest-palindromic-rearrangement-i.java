class Solution {
    public String smallestPalindrome(String s) {
        // Count the frequency of each lowercase letter in the input string.
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // firstHalf will hold the first half of the resulting palindrome.
        StringBuilder firstHalf = new StringBuilder();
        // middle holds the single center character (if any letter has an odd count).
        String middle = "";

        // Iterate from 'a' to 'z' to build the lexicographically smallest result.
        for (char c = 'a'; c <= 'z'; c++) {
            int idx = c - 'a';

            // Each pair of a character contributes one occurrence to the first half.
            int pairs = count[idx] / 2;
            if (pairs > 0) {
                firstHalf.append(String.valueOf(c).repeat(pairs));
            }

            // Remove the characters already used in pairs.
            count[idx] -= pairs * 2;

            // If one character remains, it must be the center of the palindrome.
            if (count[idx] == 1) {
                middle = String.valueOf(c);
            }
        }

        // Build the palindrome: firstHalf + middle + reverse(firstHalf).
        String left = firstHalf.toString();
        return left + middle + new StringBuilder(left).reverse();
    }
}
import collections
import math

class Solution:
    def smallestPalindrome(self, s: str, k: int) -> str:
        n = len(s)
        counts = collections.Counter(s)
        
        half_counts_dict = {char: count // 2 for char, count in counts.items()}
        
        mid_char = ""
        for char, count in counts.items():
            if count % 2 == 1:
                mid_char = char
                break
        
        half_len = n // 2
        
        alphabet = "abcdefghijklmnopqrstuvwxyz"
        
        def calculate_perms(counts_tuple, length, limit):
            if length < 0:
                return 0
            if length == 0:
                return 1
            
            p = 1
            rem_len = length
            for count in counts_tuple:
                if count < 0 or count > rem_len:
                    return 0
                
                if count > 0:
                    try:
                        comb = math.comb(rem_len, count)
                    except ValueError:
                        return 0
                    
                    # p*comb might exceed standard integer limits in other languages,
                    # but Python handles large integers. The main purpose of this
                    # check is to short-circuit if we exceed the limit.
                    if p > limit / comb if comb != 0 else float('inf'):
                        return limit + 1

                    p *= comb
                    if p > limit:
                        return limit + 1
                        
                    rem_len -= count
            return p

        initial_counts_list = [0] * 26
        for char, count in half_counts_dict.items():
            initial_counts_list[ord(char) - ord('a')] = count
        initial_counts_tuple = tuple(initial_counts_list)
        
        total_perms = calculate_perms(initial_counts_tuple, half_len, k)

        if k > total_perms:
            return ""
            
        k -= 1
        
        half_str_list = []
        current_counts_list = list(initial_counts_tuple)
        
        for i in range(half_len):
            length_of_suffix = half_len - 1 - i
            
            for char_idx in range(26):
                if current_counts_list[char_idx] > 0:
                    current_counts_list[char_idx] -= 1
                    
                    perms_count = calculate_perms(tuple(current_counts_list), length_of_suffix, k)
                    
                    if k < perms_count:
                        half_str_list.append(alphabet[char_idx])
                        break
                    else:
                        k -= perms_count
                        current_counts_list[char_idx] += 1
        
        half_str = "".join(half_str_list)
        return half_str + mid_char + half_str[::-1]
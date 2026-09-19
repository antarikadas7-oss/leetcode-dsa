class Solution:
    def reverse(self, x: int) -> int:
        INT_MIN, INT_MAX = -2**31, 2**31 - 1
        sign = -1 if x < 0 else 1
        rev = sign * int(str(abs(x))[::-1])
        return 0 if rev < INT_MIN or rev > INT_MAX else rev
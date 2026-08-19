class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        last_seen = {}       # char -> most recent index
        start = 0            # left edge of current window
        best = 0
        for i, c in enumerate(s):
            if c in last_seen and last_seen[c] >= start:
                start = last_seen[c] + 1   # jump past the duplicate
            last_seen[c] = i
            best = max(best, i - start + 1)
        return best
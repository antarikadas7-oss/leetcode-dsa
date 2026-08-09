class Solution {
    private int[] suffixSum;
    private Integer[][] memo;
    private int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;
        suffixSum = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        memo = new Integer[n][n + 1];
        return dp(0, 1);
    }

    private int dp(int i, int M) {
        if (i >= n) return 0;
        if (n - i <= 2 * M) return suffixSum[i];
        if (memo[i][M] != null) return memo[i][M];
        int best = 0;
        for (int X = 1; X <= 2 * M; X++) {
            best = Math.max(best, suffixSum[i] - dp(i + X, Math.max(M, X)));
        }
        memo[i][M] = best;
        return best;
    }
}
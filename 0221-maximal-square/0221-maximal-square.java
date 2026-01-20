class Solution {
  public int maximalSquare(char[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;
    int ans = 0;
    int[][] dp = new int[n][m];
    for (int i = n - 1; i >= 0; i--) {
      for (int j = m - 1; j >= 0; j--) {
        if (matrix[i][j] == '1') {
          if (i == n - 1 || j == m - 1)
            dp[i][j] = 1;

          else
            dp[i][j] = 1 + Math.min(dp[i][j + 1],
                Math.min(dp[i + 1][j], dp[i + 1][j + 1]));
          ans = Math.max(ans, dp[i][j]);
        }
      }
    }
    return ans * ans;
  }
}
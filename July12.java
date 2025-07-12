public class July12 {

    public static int maxGold(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] dp = new int[n][m];

        for (int col = m - 1; col >= 0; col--) {
            for (int row = 0; row < n; row++) {
                int right = (col == m - 1) ? 0 : dp[row][col + 1];
                int rightUp = (row == 0 || col == m - 1) ? 0 : dp[row - 1][col + 1];
                int rightDown = (row == n - 1 || col == m - 1) ? 0 : dp[row + 1][col + 1];

                dp[row][col] = mat[row][col] + Math.max(right, Math.max(rightUp, rightDown));
            }
        }

        int maxGold = 0;
        for (int i = 0; i < n; i++) {
            maxGold = Math.max(maxGold, dp[i][0]);
        }

        return maxGold;
    }

    public static void main(String[] args) {
        int[][] mat1 = {
            {1, 3, 3},
            {2, 1, 4},
            {0, 6, 4}
        };

        int[][] mat2 = {
            {1, 3, 1, 5},
            {2, 2, 4, 1},
            {5, 0, 2, 3},
            {0, 6, 1, 2}
        };

        System.out.println("Max Gold (Test 1): " + maxGold(mat1)); // Output: 12
        System.out.println("Max Gold (Test 2): " + maxGold(mat2)); // Output: 16
    }
}

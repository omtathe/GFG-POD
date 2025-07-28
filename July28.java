import java.util.*;

class July28 {
    public static int balanceSums(int[][] mat) {
        int n = mat.length, ops = 0;
        int[] row = new int[n], col = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                row[i] += mat[i][j];
                col[j] += mat[i][j];
            }

        for (int i = 0; i < n; i++)
            max = Math.max(max, Math.max(row[i], col[i]));

        for (int i = 0, j = 0; i < n && j < n;) {
            int diff = Math.min(max - row[i], max - col[j]);
            mat[i][j] += diff;
            row[i] += diff;
            col[j] += diff;
            ops += diff;
            if (row[i] == max) i++;
            if (col[j] == max) j++;
        }

        return ops;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2}, {3, 4}};
        System.out.println(balanceSums(mat)); // Output: 4
    }
}

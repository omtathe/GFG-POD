import java.util.*;

public class Aug21 {
    public static void main(String[] args) {
        // Example test
        int[][] mat = {
            {1, 3, 5},
            {2, 6, 9},
            {3, 6, 9}
        };

        Solution sol = new Solution();
        System.out.println("Median: " + sol.median(mat)); // Expected 5
    }
}

class Solution {
    public int median(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        // Find the minimum and maximum elements in the matrix
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, mat[i][0]);      // first element of row (smallest in row)
            max = Math.max(max, mat[i][m - 1]);  // last element of row (largest in row)
        }

        int desired = (n * m + 1) / 2;  // position of median

        while (min < max) {
            int mid = (min + max) / 2;
            int count = 0;

            // Count elements <= mid in each row using binary search
            for (int i = 0; i < n; i++) {
                count += upperBound(mat[i], mid);
            }

            if (count < desired) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min;
    }

    // Upper bound: count of numbers <= target
    private int upperBound(int[] row, int target) {
        int low = 0, high = row.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (row[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low; // number of elements <= target
    }
}

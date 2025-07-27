import java.util.Arrays;

public class July27 {

    public static void setMatrixZeroes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        boolean firstRow = false, firstCol = false;

        // Step 1: Check if first row or column has any 0s
        for (int i = 0; i < n; i++) {
            if (mat[i][0] == 0) firstCol = true;
        }

        for (int j = 0; j < m; j++) {
            if (mat[0][j] == 0) firstRow = true;
        }

        // Step 2: Use first row and column as markers
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }

        // Step 3: Set matrix cells to 0 based on markers
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }

        // Step 4: Set first row and first column to 0 if needed
        if (firstRow) {
            for (int j = 0; j < m; j++) {
                mat[0][j] = 0;
            }
        }

        if (firstCol) {
            for (int i = 0; i < n; i++) {
                mat[i][0] = 0;
            }
        }
    }

    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 0},
            {4, 5, 6},
            {7, 0, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(mat);

        setMatrixZeroes(mat);

        System.out.println("\nMatrix After Modification:");
        printMatrix(mat);
    }
}

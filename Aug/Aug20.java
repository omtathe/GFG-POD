public class Aug20 {

    public static boolean searchMatrix(int[][] mat, int x) {
        int n = mat.length, m = mat[0].length;
        int left = 0, right = n * m - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // map mid index to 2D indices
            int row = mid / m;
            int col = mid % m;
            int midVal = mat[row][col];

            if (midVal == x) return true;

            int leftVal = mat[left / m][left % m];
            int rightVal = mat[right / m][right % m];

            // normal rotated sorted array binary search logic
            if (leftVal <= midVal) { // left half sorted
                if (x >= leftVal && x < midVal) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // right half sorted
                if (x > midVal && x <= rightVal) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat1 = {
            {7, 8, 9, 10},
            {11, 12, 13, 1},
            {2, 3, 4, 5}
        };
        int x1 = 3;
        System.out.println("Search " + x1 + " -> " + searchMatrix(mat1, x1)); // true

        int[][] mat2 = {
            {6, 7, 8},
            {9, 1, 2},
            {3, 4, 5}
        };
        int x2 = 10;
        System.out.println("Search " + x2 + " -> " + searchMatrix(mat2, x2)); // false
    }
}

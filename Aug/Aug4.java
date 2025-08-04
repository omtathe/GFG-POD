public class Aug4 {
    public static void main(String[] args) {
        int[][] mat1 = {
            {1, 2, -1, -4, -20},
            {-8, -3, 4, 2, 1},
            {3, 8, 10, 1, 3},
            {-4, -1, 1, 7, -6}
        };

        int[][] mat2 = {
            {-1, -2},
            {-3, -4}
        };

        System.out.println("Output 1: " + maxRectSum(mat1)); // Output: 29
        System.out.println("Output 2: " + maxRectSum(mat2)); // Output: -1
    }

    public static int maxRectSum(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int maxSum = Integer.MIN_VALUE;

        for (int left = 0; left < m; left++) {
            int[] temp = new int[n];

            for (int right = left; right < m; right++) {
                for (int i = 0; i < n; i++) {
                    temp[i] += mat[i][right];
                }

                int currentMax = kadane(temp);
                maxSum = Math.max(maxSum, currentMax);
            }
        }

        return maxSum;
    }

    private static int kadane(int[] arr) {
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}

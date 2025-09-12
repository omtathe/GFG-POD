import java.util.Arrays;

public class Sep012 {
    public int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        if (n == 1) return 0;

        Arrays.sort(arr);

        int ans = arr[n - 1] - arr[0];

        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;

        for (int i = 1; i < n; i++) {
            int minHeight = Math.min(smallest, arr[i] - k);
            int maxHeight = Math.max(largest, arr[i - 1] + k);

            if (minHeight < 0) continue;

            ans = Math.min(ans, maxHeight - minHeight);
        }

        return ans;
    }

    public static void main(String[] args) {
        Sep012 solution = new Sep012();
        int[] arr1 = {1, 5, 8, 10};
        int k1 = 2;
        System.out.println(solution.getMinDiff(arr1, k1));  // Output: 5

        int[] arr2 = {3, 9, 12, 16, 20};
        int k2 = 3;
        System.out.println(solution.getMinDiff(arr2, k2));  // Output: 11
    }
}

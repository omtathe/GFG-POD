public class July13 {
    public static int nonLisMaxSum(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n], prev = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            prev[i] = -1;
            total += arr[i];
        }

        int maxLen = 1, last = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                last = i;
            }
        }

        boolean[] inLIS = new boolean[n];
        while (last != -1) {
            inLIS[last] = true;
            last = prev[last];
        }

        int sum = 0;
        for (int i = 0; i < n; i++)
            if (!inLIS[i]) sum += arr[i];

        return sum;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 6, 1, 2, 3, 8};
        System.out.println(nonLisMaxSum(arr1)); // Expected: 10

        int[] arr2 = {5, 4, 3, 2, 1};
        System.out.println(nonLisMaxSum(arr2)); // Expected: 14
    }
}

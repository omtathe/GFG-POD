public class July5 {
    public static void main(String[] args) {
        int[] arr = {1, 9, 2, 5, 3, 7}; // Example input

        Solution sol = new Solution();
        int result = sol.maxSum(arr);

        System.out.println("Maximum sum of adjacent pairs: " + result);
    }
}

class Solution {
    public int maxSum(int arr[]) {
        int n = arr.length;
        int ans = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            ans = Math.max(arr[i] + arr[i - 1], ans);
        }

        return ans;
    }
}

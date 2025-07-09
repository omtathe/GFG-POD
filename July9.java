import java.util.*;

public class July9 {
    public static int sumSubMins(int[] arr) {
        int MOD = (int)1e9 + 7;
        int n = arr.length;

        Stack<Integer> stack = new Stack<>();
        int[] prevLess = new int[n];
        int[] nextLess = new int[n];

        // Find previous less element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            prevLess[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Find next less element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nextLess[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long left = i - prevLess[i];
            long right = nextLess[i] - i;
            sum = (sum + arr[i] * left * right) % MOD;
        }

        return (int) sum;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 1, 2, 4};
        int[] arr2 = {71, 55, 82, 55};

        System.out.println("Output 1: " + sumSubMins(arr1)); // Expected: 17
        System.out.println("Output 2: " + sumSubMins(arr2)); // Expected: 593
    }
}

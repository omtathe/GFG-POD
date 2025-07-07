import java.util.*;

public class July7 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1}; // Example input

        Solution sol = new Solution();
        ArrayList<Integer> result = sol.nextLargerElement(arr);

        System.out.println("Next greater elements in circular array:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}

class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];

        for (int i = 2 * n - 1; i >= 0; i--) {
            int curr = arr[i % n];
            while (!stack.isEmpty() && stack.peek() <= curr) {
                stack.pop();
            }
            if (i < n) {
                res[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(curr);
        }

        for (int val : res) result.add(val);
        return result;
    }
}

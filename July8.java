import java.util.*;

public class July8 {
    public static void main(String[] args) {
        // Example test input
        int[] arr = {2, 1, 1, 3, 2, 1};

        Solution sol = new Solution();
        ArrayList<Integer> result = sol.findGreater(arr);

        // Print the result
        System.out.println(result);
    }
}

class Solution {
    public ArrayList<Integer> findGreater(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();

        // Step 1: Frequency map
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Stack to maintain indices of elements
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && freq.get(arr[stack.peek()]) <= freq.get(arr[i])) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = arr[stack.peek()];
            }

            stack.push(i);
        }

        for (int val : res) {
            result.add(val);
        }

        return result;
    }
}


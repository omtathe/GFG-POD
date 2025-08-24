import java.util.*;

public class Aug024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Example input
        int m = 3, k = 2;
        int[] arr = {3, 4, 2, 7, 13, 8, 5};

        Solution sol = new Solution();
        int result = sol.minDaysBloom(arr, k, m);
        System.out.println("Minimum days required = " + result);

        sc.close();
    }
}

class Solution {
    public int minDaysBloom(int[] arr, int k, int m) {
        int n = arr.length;

        // Step 1: Check feasibility
        if ((long) m * k > n) return -1;

        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int val : arr) {
            low = Math.min(low, val);
            high = Math.max(high, val);
        }

        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canMake(arr, mid, k, m)) {
                ans = mid;
                high = mid - 1; // try smaller days
            } else {
                low = mid + 1;  // need more days
            }
        }
        return ans;
    }

    private boolean canMake(int[] arr, int day, int k, int m) {
        int bouquets = 0, flowers = 0;
        for (int val : arr) {
            if (val <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0; // reset because adjacency breaks
            }
            if (bouquets >= m) return true;
        }
        return false;
    }
}

import java.util.*;

public class Aug2 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1, 2, 3, 4, 1};
        int k = 2;
        System.out.println(sol.longestSubarray(arr, k));  // Output: 3
    }
}

class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0, maxLen = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > k) prefixSum += 1;
            else prefixSum -= 1;
            if (prefixSum > 0) {
                maxLen = i + 1;
            } else {
                if (map.containsKey(prefixSum - 1)) {
                    maxLen = Math.max(maxLen, i - map.get(prefixSum - 1));
                }
            }
            map.putIfAbsent(prefixSum, i);
        }
        return maxLen;
    }
}

import java.util.HashMap;

public class July2 {

    public int totalElements(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int l = 0;

        for (int r = 0; r < n; r++) {
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);

            while (map.size() > 2 && l < r) {
                map.put(arr[l], map.get(arr[l]) - 1);
                if (map.get(arr[l]) == 0) {
                    map.remove(arr[l]);
                }
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        July2 solution = new July2();

        // Test input
        int[] arr = {1, 2, 1, 3, 4, 2, 3};

        // Output result
        int result = solution.totalElements(arr);
        System.out.println("Longest subarray with at most 2 distinct elements: " + result);
    }
}

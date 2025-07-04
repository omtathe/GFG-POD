// Subarrays With At Most K Distinct Integers
import java.util.*;

public class July4 {
    public static void main(String[] args) {
        // Example input
        int[] arr = {1, 2, 2, 3};
        int k = 2;

        // Create object and call the method
        July4 obj = new July4();
        int result = obj.countAtMostK(arr, k);
        System.out.println("Subarrays with at most " + k + " distinct elements: " + result);
    }

    public int countAtMostK(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        int left = 0, count = 0;

        for (int right = 0; right < n; right++) {
            freqMap.put(arr[right], freqMap.getOrDefault(arr[right], 0) + 1);

            while (freqMap.size() > k) {
                freqMap.put(arr[left], freqMap.get(arr[left]) - 1);
                if (freqMap.get(arr[left]) == 0) {
                    freqMap.remove(arr[left]);
                }
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }
}

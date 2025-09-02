import java.util.*;

public class Sep001 {
    public int sumOfModes(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return 0;

        // Map to store frequency of each number
        Map<Integer, Integer> freq = new HashMap<>();
        // TreeMap: freq -> TreeSet of numbers (to break ties by smallest number)
        TreeMap<Integer, TreeSet<Integer>> freqMap = new TreeMap<>();

        // Insert element into freq and freqMap
        java.util.function.Consumer<Integer> insert = (num) -> {
            int oldCount = freq.getOrDefault(num, 0);
            int newCount = oldCount + 1;
            freq.put(num, newCount);

            // remove from old count bucket
            if (oldCount > 0) {
                TreeSet<Integer> oldSet = freqMap.get(oldCount);
                oldSet.remove(num);
                if (oldSet.isEmpty()) freqMap.remove(oldCount);
            }

            // add to new count bucket
            freqMap.putIfAbsent(newCount, new TreeSet<>());
            freqMap.get(newCount).add(num);
        };

        // Remove element from freq and freqMap
        java.util.function.Consumer<Integer> remove = (num) -> {
            int oldCount = freq.get(num);
            int newCount = oldCount - 1;

            // remove from old count bucket
            TreeSet<Integer> oldSet = freqMap.get(oldCount);
            oldSet.remove(num);
            if (oldSet.isEmpty()) freqMap.remove(oldCount);

            if (newCount == 0) {
                freq.remove(num);
            } else {
                freq.put(num, newCount);
                freqMap.putIfAbsent(newCount, new TreeSet<>());
                freqMap.get(newCount).add(num);
            }
        };

        int sum = 0;

        // First window
        for (int i = 0; i < k; i++) {
            insert.accept(arr[i]);
        }
        sum += freqMap.lastEntry().getValue().first(); // mode

        // Slide the window
        for (int i = k; i < n; i++) {
            remove.accept(arr[i - k]);
            insert.accept(arr[i]);
            sum += freqMap.lastEntry().getValue().first(); // mode
        }

        return sum;
    }

    // Main method for testing
    public static void main(String[] args) {
        Sep001 solution = new Sep001();
        int[] arr = {1, 2, 2, 3, 3, 4, 4, 4};
        int k = 3;
        System.out.println("Sum of modes: " + solution.sumOfModes(arr, k));
    }
}

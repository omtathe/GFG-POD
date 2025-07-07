import java.util.*;

public class July6 {
    public static void main(String[] args) {
        int[] a = {1, 4, 2, 3};
        int[] b = {2, 5, 1, 6};
        int k = 5;

        Solution sol = new Solution();
        ArrayList<Integer> result = sol.topKSumPairs(a, b, k);

        System.out.println("Top " + k + " sum pairs:");
        for (int sum : result) {
            System.out.print(sum + " ");
        }
    }
}

class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        int n = a.length;
        ArrayList<Integer> result = new ArrayList<>();

        // Sort both arrays
        Arrays.sort(a);
        Arrays.sort(b);

        // Max Heap to store sum and indices
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((x, y) -> y.sum - x.sum);
        Set<String> visited = new HashSet<>();

        // Start from the largest possible sum
        maxHeap.add(new Pair(n - 1, n - 1, a[n - 1] + b[n - 1]));
        visited.add((n - 1) + "#" + (n - 1));

        while (k-- > 0 && !maxHeap.isEmpty()) {
            Pair current = maxHeap.poll();
            result.add(current.sum);

            int i = current.i;
            int j = current.j;

            // Move left in array 'a'
            if (i - 1 >= 0) {
                String key = (i - 1) + "#" + j;
                if (!visited.contains(key)) {
                    maxHeap.add(new Pair(i - 1, j, a[i - 1] + b[j]));
                    visited.add(key);
                }
            }

            // Move up in array 'b'
            if (j - 1 >= 0) {
                String key = i + "#" + (j - 1);
                if (!visited.contains(key)) {
                    maxHeap.add(new Pair(i, j - 1, a[i] + b[j - 1]));
                    visited.add(key);
                }
            }
        }

        return result;
    }

    // Helper Pair class
    static class Pair {
        int i, j, sum;
        Pair(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }
}

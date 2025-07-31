import java.util.*;

public class July31 {
    public static int powerfulInteger(int[][] intervals, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] i : intervals) {
            map.put(i[0], map.getOrDefault(i[0], 0) + 1);
            map.put(i[1] + 1, map.getOrDefault(i[1] + 1, 0) - 1);
        }

        int count = 0, last = -1, max = -1;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int point = e.getKey();
            if (count >= k && last != -1) {
                max = Math.max(max, point - 1);
            }
            count += e.getValue();
            last = point;
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1, 3}, {4, 6}, {3, 4}};
        int[][] intervals2 = {{1, 4}, {12, 45}, {3, 8}, {10, 12}};
        int[][] intervals3 = {{16, 21}, {5, 8}, {12, 17}, {17, 29}, {9, 24}};

        System.out.println(powerfulInteger(intervals1, 2)); // 4
        System.out.println(powerfulInteger(intervals2, 3)); // -1
        System.out.println(powerfulInteger(intervals3, 3)); // 21
    }
}

import java.util.*;

public class Aug1 {
    public static void main(String[] args) {
        String[] arr1 = {"aeio", "aa", "bc", "ot", "cdbd"};
        String[] arr2 = {"ab", "be"};
        String[] arr3 = {"tz", "gfg", "ae"};
        System.out.println(countBalanced(arr1));
        System.out.println(countBalanced(arr2));
        System.out.println(countBalanced(arr3));
    }

    static int countBalanced(String[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, diff = 0;
        for (String s : arr) {
            for (char ch : s.toCharArray())
                diff += "aeiou".indexOf(ch) >= 0 ? 1 : -1;
            count += map.getOrDefault(diff, 0);
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        return count;
    }
}

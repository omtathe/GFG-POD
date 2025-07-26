import java.util.*;

public class July26 {
    public ArrayList<Integer> findMajority(int[] arr) {
        int n = arr.length, c1 = 0, c2 = 0;
        Integer a = null, b = null;

        for (int num : arr) {
            if (a != null && num == a) c1++;
            else if (b != null && num == b) c2++;
            else if (c1 == 0) { a = num; c1 = 1; }
            else if (c2 == 0) { b = num; c2 = 1; }
            else { c1--; c2--; }
        }

        c1 = c2 = 0;
        for (int num : arr) {
            if (a != null && num == a) c1++;
            else if (b != null && num == b) c2++;
        }

        ArrayList<Integer> res = new ArrayList<>();
        if (c1 > n / 3) res.add(a);
        if (c2 > n / 3) res.add(b);
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        July26 obj = new July26();

        // Example input
        int[] arr = {2, 2, 1, 3, 1, 1, 3, 3};

        ArrayList<Integer> result = obj.findMajority(arr);
        System.out.println("Majority elements (> n/3): " + result);
    }
}


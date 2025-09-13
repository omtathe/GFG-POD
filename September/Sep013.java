import java.util.Arrays;
import java.util.Collections;

public class Sep013 {
    public static int minCost(int n, int m, int[] x, int[] y) {
        Integer[] xCost = Arrays.stream(x).boxed().toArray(Integer[]::new);
        Integer[] yCost = Arrays.stream(y).boxed().toArray(Integer[]::new);
        Arrays.sort(xCost, Collections.reverseOrder());
        Arrays.sort(yCost, Collections.reverseOrder());

        int i = 0, j = 0;
        int verticalSegments = 1, horizontalSegments = 1;
        long totalCost = 0;
        int mod = (int)1e9 + 7;

        while (i < xCost.length && j < yCost.length) {
            if (xCost[i] >= yCost[j]) {
                totalCost = (totalCost + (long) xCost[i] * horizontalSegments) % mod;
                verticalSegments++;
                i++;
            } else {
                totalCost = (totalCost + (long) yCost[j] * verticalSegments) % mod;
                horizontalSegments++;
                j++;
            }
        }

        while (i < xCost.length) {
            totalCost = (totalCost + (long) xCost[i] * horizontalSegments) % mod;
            verticalSegments++;
            i++;
        }

        while (j < yCost.length) {
            totalCost = (totalCost + (long) yCost[j] * verticalSegments) % mod;
            horizontalSegments++;
            j++;
        }

        return (int) totalCost;
    }

    public static void main(String[] args) {
        int n = 4, m = 6;
        int[] x = {2, 1, 3, 1, 4};
        int[] y = {4, 1, 2};
        System.out.println(minCost(n, m, x, y));
    }
}

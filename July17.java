import java.util.*;

public class July17 {

    public static int maxKPower(int n, int k) {
        // Prime factorize k
        Map<Integer, Integer> primeFactors = getPrimeFactors(k);
        int result = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : primeFactors.entrySet()) {
            int prime = entry.getKey();
            int exponentInK = entry.getValue();

            // Count exponent of 'prime' in n!
            int countInFactorial = 0;
            int power = prime;
            while (power <= n) {
                countInFactorial += n / power;
                if (power > n / prime) break; // Prevent overflow
                power *= prime;
            }

            result = Math.min(result, countInFactorial / exponentInK);
        }

        return result;
    }

    private static Map<Integer, Integer> getPrimeFactors(int k) {
        Map<Integer, Integer> factors = new HashMap<>();
        for (int i = 2; i * i <= k; i++) {
            while (k % i == 0) {
                factors.put(i, factors.getOrDefault(i, 0) + 1);
                k /= i;
            }
        }
        if (k > 1) {
            factors.put(k, 1);
        }
        return factors;
    }

    // Optional: main method to test
    public static void main(String[] args) {
        int n1 = 7, k1 = 2;
        System.out.println("maxKPower(" + n1 + ", " + k1 + ") = " + maxKPower(n1, k1));  // Output: 4

        int n2 = 10, k2 = 9;
        System.out.println("maxKPower(" + n2 + ", " + k2 + ") = " + maxKPower(n2, k2));  // Output: 2
    }
}
